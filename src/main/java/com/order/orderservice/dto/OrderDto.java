package com.order.orderservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Integer orderId;
    @NotBlank(message = "")
    private LocalDateTime orderDate;
    @NotBlank(message = "")
    private Integer customerId;
    @NotBlank(message = "")
    private String customerName;
    @NotBlank(message = "")
    private String customerAddress;
    @NotBlank(message = "")
    private String customerPhone;
    @NotBlank(message = "")
    private String orderStatus;

}
