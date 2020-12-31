package com.fuqiang.producer.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * TODO //
 *
 * <p> Title: ProducerController </p >
 * <p> Description: ProducerController </p >
 * <p> History: 2020/12/18 15:11 </p >
 * <pre>
 *      Copyright (c) 2020 FQ (fuqiangvn@163.com) , ltd.
 * </pre>
 * Author  FQ
 * Version 0.0.1.RELEASE
 */
@RestController
@RequestMapping("/producer")
@Slf4j
public class ProducerController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @PostMapping("/orderlysend")
    public String orderlysend(@RequestParam("id") String id) throws InterruptedException {
//        String orderId = UUID.randomUUID().toString().replace("-", "");
//        SendResult sendResult = rocketMQTemplate.syncSendOrderly("orderly-topic", "订单创建", orderId);
//        log.info("message：{}，orderId：{}，queueId：{}", "订单创建", orderId, sendResult.getMessageQueue().getQueueId());
////        Thread.sleep(1000);
//        SendResult sendResult1 = rocketMQTemplate.syncSendOrderly("orderly-topic", "订单支付", orderId);
//        log.info("message：{}，orderId：{}，queueId：{}", "订单支付", orderId, sendResult1.getMessageQueue().getQueueId());
////        Thread.sleep(1000);
//        SendResult sendResult2 = rocketMQTemplate.syncSendOrderly("orderly-topic", "订单发货", orderId);
//        log.info("message：{}，orderId：{}，queueId：{}", "订单发货", orderId, sendResult2.getMessageQueue().getQueueId());
////        Thread.sleep(1000);
//        SendResult sendResult3 = rocketMQTemplate.syncSendOrderly("orderly-topic", "订单完成", orderId);
//        log.info("message：{}，orderId：{}，queueId：{}", "订单完成", orderId, sendResult3.getMessageQueue().getQueueId());
        for (int i = 1; i < 10; i++) {
            SendResult sendResult = rocketMQTemplate.syncSendOrderly("orderly_topic", "测试顺序消息" + i, String.valueOf(i));
            log.info("message：{}，id：{}，queueId：{}", "测试顺序消息" + i, i, sendResult.getMessageQueue().getQueueId());
        }
        return "OK";
    }

    @PostMapping("/randomsend")
    public String randomsend(@RequestParam("id") String id) {
        for (int i = 1; i < 10; i++) {
            SendResult sendResult = rocketMQTemplate.syncSend("random_topic", "随机消息" + i);
            log.info("message：{}，id：{}，queueId：{}", "随机消息" + i, i, sendResult.getMessageQueue().getQueueId());
        }
        return "OK";
    }
}
