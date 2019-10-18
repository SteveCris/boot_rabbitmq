package com.ouyue.xiwennews.listener;
import com.ouyue.xiwennews.common.constants.RabbitMQConstants;
import com.ouyue.xiwennews.common.utils.IPUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.Query;
import javax.management.QueryExp;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Set;

/**
 * 启动 初始化
 */
public class StartInitServletListener implements ServletContextListener {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    private Integer serverPort;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        logger.info("启动初始化 [start]");
        try {
            InetAddress localHostIp = IPUtil.getLocalHostLANAddress();
            logger.info("启动初始化 [获取IP地址] " + localHostIp.getHostAddress());

            if(null == serverPort || serverPort.intValue() <= 0){
                throw new IllegalArgumentException("启动初始化 [端口] 错误,请检查 [spring.server.port]项配置 " + serverPort);
            }else{
                logger.info("启动初始化 [端口] 初始化 [server.port=" + serverPort + "]项配置端口成功");
            }

            //尝试去 server.xml 中加载 端口号
            Integer portFromServerXml = getPortFromServerXml();
            if(null != portFromServerXml && portFromServerXml.intValue() != serverPort.intValue() ){
                throw new IllegalArgumentException("启动初始化 [端口] 错误,[server.port]项配置和Tomcat的[server.xml]文件中的端口不一致\"");
            }

            String id = localHostIp.getHostAddress() + ":" + serverPort;
            RabbitMQConstants.MQ_MSG_TOTAL_KEY_THIS += id;

            logger.info("启动初始化 [Redis Key] [" + RabbitMQConstants.MQ_MSG_TOTAL_KEY_THIS +"]");

        }catch (Exception e){
            logger.error("启动初始化 [fail] [TOMCAT停止] ", e);
            System.exit(-1);//系统直接退出
        }
        logger.info("启动初始化 [end]");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        //do nothing
    }

    public Integer getPortFromServerXml(){
        MBeanServer beanServer = ManagementFactory.getPlatformMBeanServer();
        QueryExp queryExp = Query.match(Query.attr("protocol"), Query.value("HTTP/1.1"));
        try{
            Set<ObjectName> objectNames = beanServer.queryNames(new ObjectName("*:type=Connector,*"),queryExp);
            String port = objectNames.iterator().next().getKeyProperty("port");
            logger.info("启动初始化 [端口] 尝试从 server.xml 文件中读取端口,[port=" + port + "]");
            return Integer.valueOf(port);
        }catch (Exception e){
            logger.warn("启动初始化 [端口] 尝试从 server.xml 文件中读取端口失败");
            return null;
        }
    }

    public void setServerPort(Integer serverPort) {
        this.serverPort = serverPort;
    }
}
