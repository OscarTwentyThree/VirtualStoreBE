package com.virtualstore.virtualstore.mappers;

import java.util.Collection;

import org.mapstruct.*;

import com.virtualstore.virtualstore.dtos.CategoryBasicInfo;
import com.virtualstore.virtualstore.entities.Category;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoryMapper {

    CategoryBasicInfo categoryToCategoryBasicInfo(Category category);
    Collection<CategoryBasicInfo> categoriesToCategoryBasicInfos(Collection<Category> categories);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void categoryBasicInfoToCategory(CategoryBasicInfo categoryBasicInfo, @MappingTarget Category category);
    
}
