package com.virtualstore.virtualstore.mappers;
import java.util.Collection;

import org.mapstruct.*;

import com.virtualstore.virtualstore.dtos.BillBasicInfo;
import com.virtualstore.virtualstore.dtos.BillForOrder;
import com.virtualstore.virtualstore.entities.Bill;
import com.virtualstore.virtualstore.dtos.BillManagement;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BillMapper {

    BillBasicInfo billtoBillBasicInfo(Bill bill);
    Collection<BillBasicInfo> billstoBillBasicInfos(Collection<Bill> bills);

    BillManagement billtoBillManagement(Bill bill);
    Collection<BillManagement> billstoBillsmanagement(Collection<Bill> bills);

    BillForOrder billtoBillForOrder(Bill bill);
    Collection<BillForOrder> billstoBillsForOrder(Collection<Bill> bills);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void billBasicInfoToBill(BillBasicInfo billBasicInfo, @MappingTarget Bill bill);


}
