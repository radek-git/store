package com.radek.store.mapper;

import com.radek.store.dto.categories.AdminCategoryDTO;
import com.radek.store.dto.categories.CategoryDTO;
import com.radek.store.dto.categories.EmployeeCategoryDTO;
import com.radek.store.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    List<CategoryDTO> toDTO(List<Category> categories);


    AdminCategoryDTO toAdminCategoryDTO(Category category);

    List<AdminCategoryDTO> toAdminCategoryDTO(List<Category> categories);


    EmployeeCategoryDTO toEmployeeCategoryDTO(Category category);

    List<EmployeeCategoryDTO> toEmployeeCategoryDTO(List<Category> categories);

}
