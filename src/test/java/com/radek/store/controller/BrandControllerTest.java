//package com.radek.store.controller;
//
//import com.radek.store.SampleDataGenerator;
//import com.radek.store.dto.brands.BrandDTO;
//import com.radek.store.entity.Brand;
//import com.radek.store.mapper.BrandMapper;
//import com.radek.store.service.BrandService;
//import com.radek.store.utils.JSONUtils;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.util.List;
//
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//@AutoConfigureMockMvc
//public class BrandControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private BrandService brandService;
//
//    @MockBean
//    private BrandMapper brandMapper;
//
//
//    @Test
//    public void shouldReturnListOfBrands() throws Exception {
//        Brand brand1 = SampleDataGenerator.getBrand();
//        Brand brand2 = SampleDataGenerator.getBrand();
//
//        List<Brand> brands = List.of(brand1, brand2);
//
//        List<BrandDTO> brandDTOS = List.of(
//                new BrandDTO("wines"),
//                new BrandDTO("dildos")
//        );
//
//        when(brandMapper.toDTO(brands)).thenReturn(brandDTOS);
//
//        List<BrandDTO> brandDTOList = brandMapper.toDTO(brands);
//
//        when(brandService.findAll(PageRequest.of(0, 30))).thenReturn(brands);
//
//        mockMvc.perform(get("/api/brands")).andExpect(status().isOk())
//                .andExpect(content().json(JSONUtils.toJsonString(brandDTOList, true)));
//    }
//
//
//    @Test
//    public void shouldReturnBrandById() throws Exception {
//        Brand brand = SampleDataGenerator.getBrand();
//        BrandDTO brandDTO = new BrandDTO("wines");
//
//        when(brandMapper.toDTO(brand)).thenReturn(brandDTO);
//        BrandDTO dto = brandMapper.toDTO(brand);
//
//        when(brandService.findById(brand.getId()));
//
//        mockMvc.perform(get("/api/brands/id")).andExpect(status().isOk())
//                .andExpect(content().json(JSONUtils.toJsonString(dto, true)));
//    }
//}
