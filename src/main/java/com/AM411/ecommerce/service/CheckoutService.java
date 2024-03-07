package com.AM411.ecommerce.service;

import com.AM411.ecommerce.dto.Purchase;
import com.AM411.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);
}
