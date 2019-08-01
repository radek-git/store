package com.radek.store.mapper;

import com.radek.store.SampleDataGenerator;
import com.radek.store.dto.brands.BrandDTO;
import com.radek.store.entity.Brand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class BrandMapperTest {

    private BrandMapper brandMapper = new BrandMapperImpl();

    @Test
    public void shouldMapBrandToDTO() {
        Brand brand = SampleDataGenerator.getBrand();

        BrandDTO brandDTO = brandMapper.toDTO(brand);

        assertEquals("computers", brandDTO.getName());
    }

    @Test
    public void shouldMapBrandListToDTO() {
        Brand brand1 = SampleDataGenerator.getBrand();
        Brand brand2 = SampleDataGenerator.getBrand();
        brand2.setName("computers1");

        List<Brand> brands = List.of(brand1, brand2);

        //when
        List<BrandDTO> brandDTOS = brandMapper.toDTO(brands);

        //then
        assertEquals("computers", brandDTOS.get(0).getName());
        assertEquals("computers1", brandDTOS.get(1).getName());

    }
}
