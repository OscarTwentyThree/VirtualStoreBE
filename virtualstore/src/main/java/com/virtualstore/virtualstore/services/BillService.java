package com.virtualstore.virtualstore.services;

import java.util.Collection;
import com.virtualstore.virtualstore.entities.Bill;

public interface BillService {

    public abstract void createBill(Bill bill);
    public abstract void updateBill(Long id, Bill bill);
    public abstract void deleteBill(Long id);
    public abstract Collection<Bill> getBills();
    public abstract Bill getBill(Long id);

}