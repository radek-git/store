package com.radek.store.mapper;

import com.radek.store.SampleDataGenerator;
import com.radek.store.dto.categories.CategoryDTO;
import com.radek.store.entity.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class CategoryMapperTest {

    private CategoryMapper categoryMapper = new CategoryMapperImpl();

    @Test
    public void shouldMapCategoryToDTO() {
        Category category = SampleDataGenerator.getCategory();
        CategoryDTO categoryDTO = categoryMapper.toDTO(category);

        assertEquals(category.getName(), categoryDTO.getName());
    }

    @Test
    public void shouldMapListOfCategoriesToDTO() {
        Category category1 = SampleDataGenerator.getCategory();
        Category category2 = SampleDataGenerator.getCategory();

        List<Category> categories = List.of(category1, category2);
        List<CategoryDTO> categoryDTOS = categoryMapper.toDTO(categories);

        assertEquals("computers", categoryDTOS.get(0).getName());
        assertEquals("computers", categoryDTOS.get(1).getName());

    }
}
