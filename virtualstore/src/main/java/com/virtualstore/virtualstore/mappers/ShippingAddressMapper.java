package com.virtualstore.virtualstore.mappers;

import java.util.Collection;

import org.mapstruct.*;

import com.virtualstore.virtualstore.dtos.ShippingAddressBasicInfo;
import com.virtualstore.virtualstore.entities.ShippingAddress;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ShippingAddressMapper {

    ShippingAddressBasicInfo shippingAddressToShippingAddressBasicInfo(ShippingAddress shippingAddress);
    Collection<ShippingAddressBasicInfo> shippingAddressesToShippingAddressBasicInfos(Collection<ShippingAddress> shippingAddresses);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void shippingAddressBasicInfoToShippingAddress(ShippingAddressBasicInfo shippingAddressBasicInfo, @MappingTarget ShippingAddress shippingAddress);
    
}
