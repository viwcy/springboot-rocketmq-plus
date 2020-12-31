package com.fuqiang.consumer.service;

import com.fuqiang.consumer.constant.RocketMQConsumeConstants;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * TODO //
 *
 * <p> Title: OrderlyConsumerListener </p >
 * <p> Description: OrderlyConsumerListener </p >
 * <p> History: 2020/12/23 11:38 </p >
 * <pre>
 *      Copyright (c) 2020 FQ (fuqiangvn@163.com) , ltd.
 * </pre>
 * Author  FQ
 * Version 0.0.1.RELEASE
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = RocketMQConsumeConstants.ORDERLY_TOPIC, consumerGroup = RocketMQConsumeConstants.ORDERLY_CONSUME_GROUP,
        messageModel = MessageModel.CLUSTERING, consumeMode = ConsumeMode.ORDERLY)
public class OrderlyConsumerListener implements RocketMQListener<MessageExt> {
    @Override
    public void onMessage(MessageExt messageExt) {
        String string = new String(messageExt.getBody());
        log.info("topic：{}，message：{}", messageExt.getTopic(), string);
    }
}
