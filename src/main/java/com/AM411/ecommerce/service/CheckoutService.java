package com.AM411.ecommerce.service;

import com.AM411.ecommerce.dto.PaymentInfo;
import com.AM411.ecommerce.dto.Purchase;
import com.AM411.ecommerce.dto.PurchaseResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);

    PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;
}
