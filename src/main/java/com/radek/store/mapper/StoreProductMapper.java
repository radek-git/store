package com.radek.store.mapper;

import com.radek.store.dto.StoreProductDTO;
import com.radek.store.entity.Store;
import com.radek.store.entity.StoreProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public abstract class StoreProductMapper {


    private ProductMapper productMapper;

    @Autowired //w tej postaci jest mozliwosc testowania
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public StoreProductDTO toDTO(StoreProduct storeProduct) {
        if ( storeProduct == null ) {
            return null;
        }

        StoreProductDTO storeProductDTO = new StoreProductDTO();

        storeProductDTO.setStoreId( storeProductStoreId( storeProduct ) );
        storeProductDTO.setProduct( productMapper.toDTO( storeProduct.getProduct() ) );
        storeProductDTO.setQuantity( storeProduct.getQuantity() );

        return storeProductDTO;
    }


    public List<StoreProductDTO> toDTO(Collection<StoreProduct> storeProducts) {
        if ( storeProducts == null ) {
            return null;
        }

        List<StoreProductDTO> list = new ArrayList<StoreProductDTO>( storeProducts.size() );
        for ( StoreProduct storeProduct : storeProducts ) {
            list.add( toDTO( storeProduct ) );
        }

        return list;
    }

    private Long storeProductStoreId(StoreProduct storeProduct) {
        if ( storeProduct == null ) {
            return null;
        }
        Store store = storeProduct.getStore();
        if ( store == null ) {
            return null;
        }
        Long id = store.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }



}
