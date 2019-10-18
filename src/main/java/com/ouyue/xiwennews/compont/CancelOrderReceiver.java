package com.ouyue.xiwennews.compont;
import com.ouyue.xiwennews.service.UserLikeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 取消订单消息的处理者
 * Created by macro on 2018/9/14.
 */
@Component
@RabbitListener(queues = "queue_third_play")
public class CancelOrderReceiver {
    private static Logger LOGGER =LoggerFactory.getLogger(CancelOrderReceiver.class);
    @Autowired
    private UserLikeService userLikeService;
    @RabbitHandler
    public void handle(Integer msg){

        LOGGER.info("receive delay message id:{}",msg);
        System.out.println(msg);
        userLikeService.cancelLike(msg);
    }


}
