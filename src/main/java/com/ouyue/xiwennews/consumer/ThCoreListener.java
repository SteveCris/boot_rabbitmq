package com.ouyue.xiwennews.consumer;
import com.ouyue.xiwennews.service.UserLikeService;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ThCoreListener {
	private static final String ERROR_MESSAGE = "遇到不可预测错误，直接进入死信队列";

	private Logger logger = LoggerFactory.getLogger(ThCoreListener.class);

	@Autowired
	private RabbitMQProcess rabbitMQProcess;

	@Autowired
	private UserLikeService userLikeService;

	@RabbitListener(queues = { "queue_ouyue_play" })
	public void processAuditEvent(String pushEvent, Message message, Channel channel) {
		logger.info("收到");
		try {
			rabbitMQProcess.execute(new RetryCallBack() {
										@Override
										public boolean processMessage() {
											return userLikeService.processPushTime(pushEvent);
										}
									}, message, channel,
					false);
		} catch (Exception e) {
			throw new AmqpRejectAndDontRequeueException(ERROR_MESSAGE, e);
		}
	}





}
