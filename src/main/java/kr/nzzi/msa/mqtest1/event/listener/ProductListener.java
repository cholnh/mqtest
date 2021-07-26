package kr.nzzi.msa.mqtest1.event.listener;

import kr.nzzi.msa.mqtest1.event.ProductEvent;
import kr.nzzi.msa.mqtest1.configuration.RabbitMqEvent;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductListener {

    @RabbitListener(queues = RabbitMqEvent.PRODUCT_MESSAGE_EVENT)
    public void productMessageHandler(final Message message) {
        System.out.println("productMessageHandler");
        System.out.println(message);
    }

    @RabbitListener(queues = RabbitMqEvent.PRODUCT_SAVE_EVENT)
    public void productSaveHandler(final ProductEvent event) {
        System.out.println("productSaveHandler");
        System.out.println(event);
    }
}
