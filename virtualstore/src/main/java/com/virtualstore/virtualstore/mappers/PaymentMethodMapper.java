package com.virtualstore.virtualstore.mappers;

import java.util.Collection;

import org.mapstruct.*;

import com.virtualstore.virtualstore.dtos.PaymentMethodBasicInfo;
import com.virtualstore.virtualstore.entities.PaymentMethod;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PaymentMethodMapper {

    PaymentMethodBasicInfo paymentMethodToPaymentMethodBasicInfo(PaymentMethod paymentMethod);
    Collection<PaymentMethodBasicInfo> paymentMethodsToPaymentMethodBasicInfos(Collection<PaymentMethod> paymentMethods);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void paymentMethodBasicInfoToPaymentMethod(PaymentMethodBasicInfo paymentMethodBasicInfo, @MappingTarget PaymentMethod paymentMethod);
}
