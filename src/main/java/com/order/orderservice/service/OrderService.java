package com.order.orderservice.service;

import com.order.orderservice.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderDto> getAllOrders();
    OrderDto createOrder(OrderDto orderDto);
    Optional<OrderDto> getOrderById(Integer id);
}
