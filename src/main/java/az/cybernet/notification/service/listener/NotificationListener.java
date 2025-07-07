package az.cybernet.notification.service.listener;

import az.cybernet.notification.service.entity.OrderEntity;
import az.cybernet.notification.service.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static lombok.AccessLevel.PRIVATE;

@Slf4j
@Component
@RequiredArgsConstructor
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class NotificationListener {
    EmailService emailService;

    @KafkaListener(topics = "order-topic", groupId = "notification-group", containerFactory = "kafkaListenerContainerFactory")
    public void consume(OrderEntity order) {
        String message = String.format("📩 New Order Received:\n- Customer: %s\n- Product: %s\n- Quantity: %d\n- Price: %.2f\n- Status: %s\n- Created At: %s",
                order.getCustomerName(),
                order.getProductName(),
                order.getQuantity(),
                order.getPrice(),
                order.getStatus(),
                order.getCreatedAt());

        log.info("📧 Sending email to customer with order details...");

        emailService.sendEmail("afganmustafayev99@gmail.com", "Order information", message);
    }
}

