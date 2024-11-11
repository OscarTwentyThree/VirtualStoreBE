package com.virtualstore.virtualstore.mappers;

import java.util.Collection;

import org.mapstruct.*;

import com.virtualstore.virtualstore.dtos.OrderBasicInfo;
import com.virtualstore.virtualstore.entities.Order;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {

    OrderBasicInfo orderToOrderBasicInfo(Order order);
    Collection<OrderBasicInfo> ordersToOrderBasicInfos(Collection<Order> orders);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void orderBasicInfoToOrder(OrderBasicInfo orderBasicInfo, @MappingTarget Order order);



    
}
