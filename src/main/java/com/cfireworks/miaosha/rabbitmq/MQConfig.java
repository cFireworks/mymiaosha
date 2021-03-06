package com.cfireworks.miaosha.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 配置
 * @author: cfireworks
 * @create: 2020-05-24 11:06
 **/
@Configuration
public class MQConfig {

    public static final String MIAOSHA_QUEUE = "miaosha_queue";

    public static final String QUEUE = "queue";
    public static final String TOPIC_QUEUE1 = "topic_queue1";
    public static final String TOPIC_QUEUE2 = "topic_queue2";
    public static final String HEADER_QUEUE = "header_queue";
    public static final String TOPIC_EXCHANGE = "topic_exchange";
    public static final String ROUTING_KEY1 = "topic.key1";
    public static final String ROUTING_KEY2 = "topic.#";
    public static final String FANOUT_EXCHANGE = "fanout_exchange";
    public static final String HEADERS_EXCHANGE = "headers_exchange";

    @Bean
    public Queue miaoshaQueue(){
        return new Queue(MIAOSHA_QUEUE, true);
    }

//    /**
//     * Direct模式
//     * @return
//     */
//    @Bean
//    public Queue queue(){
//        return new Queue(QUEUE, true);
//    }
//
//    /**
//     * Topic模式
//     * @return
//     */
//    @Bean
//    public Queue topicQueue1(){
//        return new Queue(TOPIC_QUEUE1, true);
//    }
//
//    @Bean
//    public Queue topicQueue2(){
//        return new Queue(TOPIC_QUEUE2, true);
//    }
//
//    @Bean
//    public TopicExchange topicExchange(){
//        return new TopicExchange(TOPIC_EXCHANGE);
//    }
//
//    @Bean
//    public Binding topicBinding1(){
//        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with(ROUTING_KEY1);
//}
//
//    @Bean
//    public Binding topicBinding2(){
//        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with(ROUTING_KEY2);
//    }
//
//    /**
//     * Fanout模式 交换机Exchange
//     * @return
//     */
//    @Bean
//    public FanoutExchange fanoutExchange(){
//        return new FanoutExchange(FANOUT_EXCHANGE);
//    }
//    @Bean
//    public Binding fanoutBinding1(){
//        return BindingBuilder.bind(topicQueue1()).to(fanoutExchange());
//    }
//    @Bean
//    public Binding fanoutBinding2(){
//        return BindingBuilder.bind(topicQueue2()).to(fanoutExchange());
//    }
//
//    /**
//     * Header模式 交换机Exchange
//     * @return
//     */
//    @Bean
//    public HeadersExchange headerExchange(){
//        return new HeadersExchange(HEADERS_EXCHANGE);
//    }
//    @Bean
//    public Queue headerQueue1(){
//        return new Queue(HEADER_QUEUE, true);
//    }
//    @Bean
//    public Binding headerBinding(){
//        Map<String, Object> map = new HashMap();
//        map.put("header1", "value1");
//        map.put("header2", "value2");
//        return BindingBuilder.bind(headerQueue1()).to(headerExchange()).whereAll(map).match();
//    }
}
