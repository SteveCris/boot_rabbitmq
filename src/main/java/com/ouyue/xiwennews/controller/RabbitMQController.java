package com.ouyue.xiwennews.controller;
import com.alibaba.fastjson.JSON;
import com.ouyue.xiwennews.common.base.BaseResponse;
import com.ouyue.xiwennews.common.model.MqDto;
import com.ouyue.xiwennews.service.RabbitMQSenderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api("消息管理")
@Controller
@RequestMapping(value = "/mq")
public class RabbitMQController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RabbitMQSenderService rabbitMQSenderService;

    /**
     *
     * @param virtualHost 虚拟机
     * @param exchange  交换机
     * @param routingKey 路由key
     * @param msg 消息体
     * @return
     * @throws Exception
     */
    @ApiOperation("消息发送方")
    @PostMapping("/send")
    @ResponseBody
    public BaseResponse<String> send(
            @RequestParam(required=true) String virtualHost,
            @RequestParam(required=true) String exchange,
            String routingKey,
            @RequestParam(required=true) String msg)throws Exception{
        BaseResponse response =new BaseResponse();
       // MqDto mqDto = JSON.parseObject(msg, MqDto.class);
        rabbitMQSenderService.send(virtualHost, exchange, routingKey, msg);
        logger.info("[发送消息成功], [virtualHost = "+virtualHost+"],[exchange="+exchange+"][routingKey="+routingKey+"][msg="+msg+"]");
        return response;
    }

    /**
     *
     * @param virtualHost
     * @param exchange
     * @param routingKey
     * @return
     */
    @ApiOperation("消息发送确认")
    @PostMapping("/sendAndConfirm")
    @ResponseBody
    public BaseResponse<String> sendAndConfirmTest(
            @RequestParam(required=true) String virtualHost,
            @RequestParam(required=true) String exchange,
            String routingKey,
            @RequestParam(required=true) String msg)throws Exception{
        BaseResponse response =new BaseResponse();
        rabbitMQSenderService.sendAndConfirm(virtualHost, exchange, routingKey, msg);

        logger.info("[发送消息成功], [virtualHost = "+virtualHost+"],[exchange="+exchange+"][routingKey="+routingKey+"][msg="+msg+"]");
        return response;
    }
}