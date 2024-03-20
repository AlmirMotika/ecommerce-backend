package com.AM411.ecommerce.service;

import com.AM411.ecommerce.dao.CustomerRepository;
import com.AM411.ecommerce.dto.Purchase;
import com.AM411.ecommerce.dto.PurchaseResponse;
import com.AM411.ecommerce.entity.Customer;
import com.AM411.ecommerce.entity.Order;
import com.AM411.ecommerce.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{
    private CustomerRepository customerRepository;
    @Autowired
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }
    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {
        Order order=purchase.getOrder();

        String orderTrackingNumber=generateOrderTrackNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItem> orderItems=purchase.getOrderItems();
        orderItems.forEach(order::add);

        order.setShippingAddress(purchase.getShippingAddress());
        order.setBillingAddress(purchase.getBillingAddress());

        Customer customer= purchase.getCustomer();

        String theEmail=customer.getEmail();

        Customer customerFromDB=customerRepository.findByEmail(theEmail);

        if(customerFromDB!=null){
            customer=customerFromDB;
        }

        customer.add(order);

        customerRepository.save(customer);
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackNumber() {
        return UUID.randomUUID().toString();
    }
}
