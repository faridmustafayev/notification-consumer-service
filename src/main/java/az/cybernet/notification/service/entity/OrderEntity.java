package az.cybernet.notification.service.entity;

import az.cybernet.notification.service.model.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static lombok.AccessLevel.PRIVATE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = PRIVATE)
public class OrderEntity {
    Long id;
    String customerName;
    String productName;
    Integer quantity;
    BigDecimal price;
    OrderStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
}
