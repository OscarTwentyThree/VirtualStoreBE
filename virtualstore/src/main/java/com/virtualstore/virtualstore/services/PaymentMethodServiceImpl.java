package com.virtualstore.virtualstore.services;

import java.util.Collection;
import com.virtualstore.virtualstore.entities.PaymentMethod;
import com.virtualstore.virtualstore.repositories.PaymentMethodRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    public void createPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethodRepository.save(paymentMethod); 
    }

    @Override
    public void updatePaymentMethod(Long id, PaymentMethod paymentMethod) {
        PaymentMethod paymentMethodToUpdate = paymentMethodRepository.findById(id).get();
        paymentMethodToUpdate.setName(paymentMethod.getName());
        paymentMethodToUpdate.setBills(paymentMethod.getBills());
        paymentMethodRepository.save(paymentMethodToUpdate);
    }

    @Override
    public void deletePaymentMethod(Long id) {
        paymentMethodRepository.deleteById(id); 
    }

    @Override
    public Collection<PaymentMethod> getPaymentMethods() {
        return paymentMethodRepository.findAll();
    }

    @Override
    public PaymentMethod getPaymentMethod(Long id) {
        if(paymentMethodRepository.findById(id) == null){
            throw new RuntimeException("PaymentMethod not found");
        }else{
            return paymentMethodRepository.findById(id).get();
        }
    }
    
}
