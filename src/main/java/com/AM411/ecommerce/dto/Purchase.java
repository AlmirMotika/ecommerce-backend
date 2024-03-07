package com.AM411.ecommerce.dto;

import com.AM411.ecommerce.entity.Address;
import com.AM411.ecommerce.entity.Customer;
import com.AM411.ecommerce.entity.Order;
import com.AM411.ecommerce.entity.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;
}
