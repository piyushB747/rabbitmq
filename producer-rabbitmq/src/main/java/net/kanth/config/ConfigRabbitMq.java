package net.kanth.config;


import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigRabbitMq {

    @Bean
    public Queue userQueue() {
        return new Queue("user.queue");
    }

    @Bean
    public DirectExchange userExchange() {
        return new DirectExchange("user.exchange");
    }
    // Step 3 - Bind Queue to Exchange with Routing Key
    @Bean
    public Binding userBinding() {
        return BindingBuilder
                .bind(userQueue())
                .to(userExchange())
                .with("user.routingkey");
    }
}
