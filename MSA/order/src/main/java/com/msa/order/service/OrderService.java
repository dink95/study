package com.msa.order.service;


import com.msa.order.dto.OrderDto;
import com.msa.order.jpa.OrderEntity;

public interface OrderService {

    OrderDto createOrder(OrderDto orderDto);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<OrderEntity> getOrderByUserId(String userId);

}
