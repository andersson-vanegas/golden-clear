package org.golden.clear.products.Infrastructure.mapper;

import org.golden.clear.products.Domain.models.Producto;
import org.golden.clear.products.Infrastructure.entities.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id",target = "id"),
            @Mapping(source = "nombre",target = "nombre"),
            @Mapping(source = "price",target = "price"),

    })
    Producto PRODUCTO(ProductEntity productEntity);

    List<Producto> PRODUCTO_LIST(List<ProductEntity>productEntities);

    @InheritInverseConfiguration
    ProductEntity PRODUCT_ENTITY(Producto favorites);
}
