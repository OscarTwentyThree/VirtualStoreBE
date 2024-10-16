package com.virtualstore.virtualstore.services;
import java.util.Collection;

import com.virtualstore.virtualstore.entities.ShippingAddress;
public interface ShippingAddressService {

    public abstract void createShippingAddress(ShippingAddress ShippingAddress);
    public abstract void updateShippingAddress(Long id, ShippingAddress ShippingAddress);
    public abstract void deleteShippingAddress(Long id);
    public abstract Collection<ShippingAddress> getShippingAddresses();
    public abstract ShippingAddress getShippingAddress(Long id);
    
}
