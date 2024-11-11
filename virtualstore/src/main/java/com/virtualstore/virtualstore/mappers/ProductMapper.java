package com.virtualstore.virtualstore.mappers;

import java.util.*;

import org.mapstruct.*;

import com.virtualstore.virtualstore.dtos.ProductBasicInfo;
import com.virtualstore.virtualstore.entities.Product;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductBasicInfo productToProductBasicInfo(Product product);
    Collection<ProductBasicInfo> productsToProductBasicInfos(Collection<Product> products);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void productBasicInfoToProduct(ProductBasicInfo productBasicInfo, @MappingTarget Product product);

}