package com.virtualstore.virtualstore.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Collection;
import com.virtualstore.virtualstore.entities.ShippingAddress;
import com.virtualstore.virtualstore.repositories.ShippingAddressRepository;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;

    @Override
    public void createShippingAddress(ShippingAddress shippingAddress) {
        shippingAddressRepository.save(shippingAddress);
    }

    @Override
    public void updateShippingAddress(Long id, ShippingAddress shippingAddress) {
        ShippingAddress shippingAddressToUpdate = shippingAddressRepository.findById(id).get();
        shippingAddressToUpdate.setStreet(shippingAddress.getStreet());
        shippingAddressToUpdate.setCity(shippingAddress.getCity());
        shippingAddressToUpdate.setState(shippingAddress.getState());
        shippingAddressToUpdate.setCountry(shippingAddress.getCountry());
        shippingAddressToUpdate.setZipCode(shippingAddress.getZipCode());
        shippingAddressToUpdate.setBills(shippingAddress.getBills());
        shippingAddressRepository.save(shippingAddressToUpdate);
    }

    @Override
    public void deleteShippingAddress(Long id) {
        shippingAddressRepository.deleteById(id);
    }

    @Override
    public Collection<ShippingAddress> getShippingAddresses() {
        return shippingAddressRepository.findAll();
    }


    @Override
    public ShippingAddress getShippingAddress(Long id) {
        if(shippingAddressRepository.findById(id) == null){
            throw new RuntimeException("ShippingAddress not found");
        }else{
            return shippingAddressRepository.findById(id).get();
        }
    }


    
}
