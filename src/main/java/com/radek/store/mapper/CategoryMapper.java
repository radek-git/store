package com.radek.store.mapper;

import com.radek.store.entity.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper toDTO(Category category);

    List<CategoryMapper> toDTO(List<Category> categories);

    Category toEntity(CategoryMapper categoryMapper);

    List<Category> toEntty(List<CategoryMapper> categoryMappers);
}
