package net.kanth.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbitMqTopicExchange {

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topic.exchange");
    }

    @Bean
    public Queue orderQueue(){
        return new Queue("order.queue");
    }

    @Bean
    public Queue paymentQUeue(){
        return new Queue("payment.queue");
    }

    @Bean
    public Queue allQueue1(){
        return new Queue("all.queue");
    }


    @Bean
    public Binding bindingOrderQueue(){
        return BindingBuilder
                .bind(orderQueue())
                .to(topicExchange())
                .with("Order.*");  //only one word after order/
    }

    @Bean
    public Binding bindingPaymentQueue(){
        return BindingBuilder
                .bind(paymentQUeue())
                .to(topicExchange())
                .with("payment.*");
    }

    @Bean
    public Binding allQueue(){
        return BindingBuilder
                .bind(allQueue1())
                .to(topicExchange())
                .with("#");
    }

}
