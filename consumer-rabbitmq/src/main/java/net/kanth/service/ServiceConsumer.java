package net.kanth.service;


import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
public class ServiceConsumer {

    private static final Logger log = LoggerFactory.getLogger(ServiceConsumer.class);

   // @RabbitListener(queues = "user.queue")
    public void consumeUserMessage(String message) {
        log.info("Message received from queue: {}", message);

        // Notify customer
        log.info("Sending notification to customer: {}", message);
    }

    @RabbitListener(queues = "order.queue")
    public void orderQueueConsumer(String message){
        log.info("Order professional university {}",message);
    }
    @RabbitListener(queues = "payment.queue")
    public void paymentQueueConsumer(String message){
        log.info("Payment professional university {}",message);

    } @RabbitListener(queues = "all.queue")
    public void allQueueConsumer(String message){
        log.info("Eternal professional university {}",message);
    }



    @RabbitListener(queues = "user.queue")
    public void consumeUserMessage(String message, Channel channel,
                                   @Header(AmqpHeaders.DELIVERY_TAG) long tag) {

        try {
            log.info("Message received: {}", message);
            if(!message.contains("fail")) {
                //throw new RuntimeException("Simulated Exception");
            }

            // Process message
            log.info("Notifying customer...");


            // ✅ Send ACK — message processed successfully
            channel.basicAck(tag, false);

        } catch (Exception e) {
            try {
                // ❌ Send NACK — message processing failed
                // true = requeue the message
                log.info("RAM KAHANI");
                channel.basicNack(tag, false, true);
            } catch (Exception ex) {
                log.error("Error sending NACK", ex);
            }
        }
    }
}
