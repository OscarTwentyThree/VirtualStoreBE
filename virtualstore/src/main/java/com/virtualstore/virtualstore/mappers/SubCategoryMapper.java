package com.virtualstore.virtualstore.mappers;

import java.util.Collection;

import org.mapstruct.*;

import com.virtualstore.virtualstore.dtos.SubCategoryBasicInfo;
import com.virtualstore.virtualstore.entities.SubCategory;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface SubCategoryMapper {

    SubCategoryBasicInfo subCategoryToSubCategoryBasicInfo(SubCategory subCategory);
    Collection<SubCategoryBasicInfo> subCategoriesToSubCategoryBasicInfos(Collection<SubCategory> subCategories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void subCategoryBasicInfoToSubCategory(SubCategoryBasicInfo subCategoryBasicInfo, @MappingTarget SubCategory subCategory);
    
}
