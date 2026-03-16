package net.kanth.service.impl;

import net.kanth.dto.PayloadCreation;
import net.kanth.service.ServiceCreation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class ServiceCreationRabbitMQ implements ServiceCreation {

    private static final Logger log = LoggerFactory.getLogger(ServiceCreationRabbitMQ.class);

    private final RabbitTemplate rabbitTemplate;

    public ServiceCreationRabbitMQ(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public PayloadCreation creationUser(PayloadCreation creation) {
        creation.setId(UUID.randomUUID()+"");
        rabbitTemplate.convertAndSend("user.exchange", "user.routingkey", creation.toString());

        return creation;
    }

    @Override
    public String crationorder(PayloadCreation user) {

        rabbitTemplate.convertAndSend("topic.exchange", "order.placed", "Order Placed!");
        rabbitTemplate.convertAndSend("topic.exchange", "payment.success", "Payment Done!");


        return "";
    }
}
