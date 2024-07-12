package com.order.orderservice.service;

import com.order.orderservice.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);
    Optional<OrderDto> getOrderById(Integer id);
    Page<OrderDto> getOrders(Pageable pageable);
}
