package com.virtualstore.virtualstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import com.virtualstore.virtualstore.entities.Bill;
import com.virtualstore.virtualstore.repositories.BillRepository;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public void createBill(Bill bill) {
        billRepository.save(bill);
    }

    @Override
    public void updateBill(Long id, Bill bill) {
        Bill billToUpdate = billRepository.findById(id).get();
        billToUpdate.setTotal(bill.getTotal());
        billToUpdate.setSubtotal(bill.getSubtotal());
        billToUpdate.setTax(bill.getTax());
        billToUpdate.setDate(bill.getDate());
        billToUpdate.setUser(bill.getUser());
        billToUpdate.setPaymentMethod(bill.getPaymentMethod());
        billToUpdate.setStatus(bill.getStatus());
        billToUpdate.setOrders(bill.getOrders());
        billToUpdate.setShippingAddress(bill.getShippingAddress());
        billRepository.save(billToUpdate);

    }

    @Override
    public void deleteBill(Long id) {
        billRepository.deleteById(id);
    }

    @Override
    public Collection<Bill> getBills() {
        return billRepository.findAll();
    }

    @Override
    public Bill getBill(Long id) {
        if(billRepository.findById(id) == null){
            throw new RuntimeException("Bill not found");
        }else{
            return billRepository.findById(id).get();
        }
    }


    

    
    
}
