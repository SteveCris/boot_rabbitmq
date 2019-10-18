package com.ouyue.xiwennews.config;

import com.alibaba.fastjson.JSON;
import com.ouyue.xiwennews.chche.RabbitRetryCache;
import com.ouyue.xiwennews.common.enums.ServiceCodeEnum;
import com.ouyue.xiwennews.common.exception.ServiceException;
import com.ouyue.xiwennews.common.model.RabbitConfig;
import com.ouyue.xiwennews.common.model.RabbitVirtualHostConfig;
import com.ouyue.xiwennews.listener.ConfirmCallBackListener;
import com.ouyue.xiwennews.listener.StartInitServletListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedWebApplicationContext;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQSenderConfig {

	private Logger logger = LoggerFactory.getLogger(getClass());

	public static final String DELAY = "_delay"; //延时队列后缀

	public static final String DLX = "_dlx"; // 死信队列后缀

	@Value(value = "classpath:rabbit.config.json")
	private Resource resource;

	@Value(value = "${context.server.port}")
	private Integer serverPort;

	/**
	 * key 使虚拟机的 名称
	 */
	private static Map<String, RabbitTemplate> RABBIT_TEMPLATE_HASHMAP = new HashMap<>();

	private static ConfirmCallBackListener confirmCallBackListener;

	@Autowired
	EmbeddedWebApplicationContext server;

	@PostConstruct
	public void init() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
		StringBuilder message = new StringBuilder();
		String line = null;
		while ((line = br.readLine()) != null) {
			message.append(line);
		}
		br.close();

		String defaultString = message.toString();
		String rabbitConfigJson = defaultString.replace("\r\n", "");

		RabbitConfig rabbitConfig = JSON.parseObject(rabbitConfigJson, RabbitConfig.class);

		for (RabbitVirtualHostConfig elem : rabbitConfig.getVirtual()) {
			CachingConnectionFactory cachingConnectionFactory = createCachingConnectionFactory(rabbitConfig.getHost(),
					rabbitConfig.getPort(), rabbitConfig.getUserName(), rabbitConfig.getPassword(), elem);

			RabbitTemplate commonTemplate = new RabbitTemplate(cachingConnectionFactory);
			commonTemplate.setMessageConverter(jsonMessageConverter());

			RABBIT_TEMPLATE_HASHMAP.put(elem.getVirtualName(), commonTemplate);

			RabbitTemplate commonTemplateConfirm = new RabbitTemplate(cachingConnectionFactory);
			commonTemplateConfirm.setMessageConverter(jsonMessageConverter());
			commonTemplateConfirm.setConfirmCallback(confirmCallBackListener);
			RABBIT_TEMPLATE_HASHMAP.put(elem.getVirtualName()+ "_confirm",  commonTemplateConfirm);

		}
	}

	/**
	 *
	 * @param host
	 * @param port
	 * @param userName
	 * @param password
	 * @param config
	 * @return
	 */
	private CachingConnectionFactory createCachingConnectionFactory(String host, int port, String userName,
			String password, RabbitVirtualHostConfig config) {
		//
		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(host, port);

		cachingConnectionFactory.setUsername(userName);
		cachingConnectionFactory.setPassword(password);

		cachingConnectionFactory.setVirtualHost(config.getVirtualName());

		cachingConnectionFactory.setPublisherConfirms(true);
		cachingConnectionFactory.setPublisherReturns(false);

		if (null != config.getChannel() && config.getChannel().intValue() > 0) {
			cachingConnectionFactory.setChannelCacheSize(config.getChannel());
		}

		if (null != config.getConnection() && config.getConnection().intValue() > 0) {
			cachingConnectionFactory.setConnectionCacheSize(config.getConnection());
		}

		cachingConnectionFactory.setCacheMode(CachingConnectionFactory.CacheMode.CONNECTION);
		cachingConnectionFactory.setConnectionLimit(5000);
		cachingConnectionFactory.setConnectionCacheSize(config.getConnection());

		return cachingConnectionFactory;
	}

	/**
	 * 获取 RabbitTemplate
	 *
	 * @param virtualHost
	 * @param needConfirm
	 * @return
	 */
	public static RabbitTemplate getRabbitTemplate(String virtualHost, boolean needConfirm) throws Exception {
		if (null == virtualHost) {
			throw new ServiceException(ServiceCodeEnum.PARAM_ILLEGAL, "队列参数为空,无法获取 RabbitTemplate ");
		}
		RabbitTemplate template = null;
		if (needConfirm) {
			template = RABBIT_TEMPLATE_HASHMAP.get(virtualHost + "_confirm");
			if(!template.isConfirmListener()){
				template.setConfirmCallback(confirmCallBackListener);
			}
		} else {
			template = RABBIT_TEMPLATE_HASHMAP.get(virtualHost);
		}
		if (null == template) {
			throw new ServiceException(ServiceCodeEnum.ERROR, "队列[" + virtualHost + "] 无法获取 RabbitTemplate ");
		}
		return template;
	}

	@Bean
	public MessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
	@Bean
    public static ConfirmCallBackListener confirmCallBackListener(RabbitRetryCache rabbitRetryCache) {
		confirmCallBackListener = new ConfirmCallBackListener(rabbitRetryCache);
    	return confirmCallBackListener;
    }

    @Bean
	public ServletListenerRegistrationBean startInitServletListener(){
		ServletListenerRegistrationBean servletListenerRegistrationBean = new ServletListenerRegistrationBean();

		StartInitServletListener temp = new StartInitServletListener();
		temp.setServerPort(serverPort);

		servletListenerRegistrationBean.setListener(temp);
		return servletListenerRegistrationBean;
	}
}
