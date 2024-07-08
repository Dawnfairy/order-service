package com.order.orderservice.service;

import com.order.orderservice.dto.OrderDto;
import com.order.orderservice.entities.Order;
import com.order.orderservice.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    public OrderServiceImpl() {
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        if(orderDto.getOrderDate() == null){
            orderDto.setOrderDate(LocalDateTime.now());
        }
        Order order = convertFromDto(orderDto);
        return convertToDto(orderRepository.save(order));
    }

    @Override
    public Optional<OrderDto> getOrderById(Integer id) {
        return orderRepository.findById(id).map(this::convertToDto);
    }

    private OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(order.getOrderId());
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
        order.setOrderId(orderDto.getOrderId());
        order.setOrderDate(orderDto.getOrderDate());
        order.setCustomerId(orderDto.getCustomerId());
        order.setCustomerAddress(orderDto.getCustomerAddress());
        order.setCustomerName(orderDto.getCustomerName());
        order.setCustomerPhone(orderDto.getCustomerPhone());
        order.setOrderStatus(orderDto.getOrderStatus());
        return order;
    }
}
