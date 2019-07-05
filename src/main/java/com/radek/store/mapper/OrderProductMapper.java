package com.radek.store.mapper;

import com.radek.store.dto.OrderProductDTO;
import com.radek.store.dto.products.ProductDTO;
import com.radek.store.entity.Order;
import com.radek.store.entity.OrderProduct;
import com.radek.store.entity.Product;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public abstract class OrderProductMapper {


    private ProductMapper productMapper;


    @Autowired
    public void setProductMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public OrderProductDTO toDTO(OrderProduct orderProduct) {
        if ( orderProduct == null ) {
            return null;
        }

        OrderProductDTO orderProductDTO = new OrderProductDTO();

        orderProductDTO.setOrderId( orderProductOrderId( orderProduct ) );
        orderProductDTO.setProduct( productMapper.toDTO( orderProduct.getProduct() ) );
        orderProductDTO.setQuantity( orderProduct.getQuantity() );
        orderProductDTO.setPrice( orderProduct.getPrice() );
        orderProductDTO.setPosition( orderProduct.getPosition() );

        return orderProductDTO;
    }


    public List<OrderProductDTO> toDTO(List<OrderProduct> orderProducts) {
        if ( orderProducts == null ) {
            return null;
        }

        List<OrderProductDTO> list = new ArrayList<OrderProductDTO>( orderProducts.size() );
        for ( OrderProduct orderProduct : orderProducts ) {
            list.add( toDTO( orderProduct ) );
        }

        return list;
    }


    public OrderProduct toEntity(OrderProductDTO orderProductDTO) {
        if ( orderProductDTO == null ) {
            return null;
        }

        OrderProduct orderProduct = new OrderProduct();

        orderProduct.setProduct( productDTOToProduct( orderProductDTO.getProduct() ) );
        orderProduct.setQuantity( orderProductDTO.getQuantity() );
        orderProduct.setPrice( orderProductDTO.getPrice() );
        orderProduct.setPosition( orderProductDTO.getPosition() );

        return orderProduct;
    }


    public List<OrderProduct> toEntity(List<OrderProductDTO> orderProductDTOS) {
        if ( orderProductDTOS == null ) {
            return null;
        }

        List<OrderProduct> list = new ArrayList<OrderProduct>( orderProductDTOS.size() );
        for ( OrderProductDTO orderProductDTO : orderProductDTOS ) {
            list.add( toEntity( orderProductDTO ) );
        }

        return list;
    }

    private Long orderProductOrderId(OrderProduct orderProduct) {
        if ( orderProduct == null ) {
            return null;
        }
        Order order = orderProduct.getOrder();
        if ( order == null ) {
            return null;
        }
        Long id = order.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Product productDTOToProduct(ProductDTO productDTO) {
        if ( productDTO == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productDTO.getId() );
        product.setName( productDTO.getName() );
        product.setPrice( productDTO.getPrice() );

        return product;
    }
}
