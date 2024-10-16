package com.virtualstore.virtualstore.services;
import java.util.Collection;

import com.virtualstore.virtualstore.entities.PaymentMethod;
public interface PaymentMethodService {

    public abstract void createPaymentMethod(PaymentMethod paymentMethod);
    public abstract void updatePaymentMethod(Long id, PaymentMethod paymentMethod);
    public abstract void deletePaymentMethod(Long id);
    public abstract Collection<PaymentMethod> getPaymentMethods();
    public abstract PaymentMethod getPaymentMethod(Long id);
    
}
