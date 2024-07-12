package com.order.orderservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private LocalDateTime orderDate;
    @NotBlank(message = "Customer ID cannot be blank")
    private Integer customerId;

    @NotBlank(message = "Customer name cannot be blank")
    private String customerName;

    @NotBlank(message = "Customer address cannot be blank")
    private String customerAddress;

    @NotBlank(message = "Customer phone cannot be blank")
    private String customerPhone;

    @NotBlank(message = "Order status cannot be blank")
    private String orderStatus;

}
