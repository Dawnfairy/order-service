package com.order.orderservice.service;

import com.order.orderservice.dto.OrderDto;
import com.order.orderservice.entities.Order;
import com.order.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = convertFromDto(orderDto);
        return convertToDto(orderRepository.save(order));
    }

    @Override
    public Optional<OrderDto> getOrderById(Integer id) {
        return orderRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public Page<OrderDto> getOrders(Pageable pageable) {
        return orderRepository.findAll(pageable).map(this::convertToDto);
    }

    private OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setCustomerId(order.getCustomerId());
        orderDto.setCustomerAddress(order.getCustomerAddress());
        orderDto.setCustomerName(order.getCustomerName());
        orderDto.setCustomerPhone(order.getCustomerPhone());
        orderDto.setOrderStatus(order.getOrderStatus());
        return orderDto;
    }

    private Order convertFromDto(OrderDto orderDto) {
        Order order = new Order();
        order.setOrderDate(LocalDateTime.now());
        order.setCustomerId(orderDto.getCustomerId());
        order.setCustomerAddress(orderDto.getCustomerAddress());
        order.setCustomerName(orderDto.getCustomerName());
        order.setCustomerPhone(orderDto.getCustomerPhone());
        order.setOrderStatus(orderDto.getOrderStatus());
        return order;
    }
}
