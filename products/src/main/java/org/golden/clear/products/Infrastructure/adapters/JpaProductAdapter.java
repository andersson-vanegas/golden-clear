package org.golden.clear.products.Infrastructure.adapters;

import org.golden.clear.products.Domain.models.Producto;
import org.golden.clear.products.Domain.ports.out.ProductRepositoryPort;
import org.golden.clear.products.Infrastructure.entities.ProductEntity;
import org.golden.clear.products.Infrastructure.mapper.ProductMapper;
import org.golden.clear.products.Infrastructure.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class JpaProductAdapter implements ProductRepositoryPort {


    @Autowired
    private  final ProductoRepository productoRepository;

    @Autowired
    private ProductMapper productMapper;


    public JpaProductAdapter(ProductoRepository productoRepository, ProductMapper productMapper) {
        this.productoRepository = productoRepository;
        this.productMapper = productMapper;
    }

    @Override
    public Producto save(Producto producto) {
        ProductEntity productEntity = productMapper.PRODUCT_ENTITY(producto);
        return productMapper.PRODUCTO(productoRepository.save(productEntity));
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id).map(productEntity -> productMapper.PRODUCTO(productEntity));
    }

    @Override
    public List<Producto> findAll() {
        List<ProductEntity> productEntity =  productoRepository.findAll();
        return  productMapper.PRODUCTO_LIST(productEntity);
    }

    @Override
    public Optional<Producto> update(Producto announcement) {
        if (productoRepository.existsById(announcement.getId())){
            ProductEntity announcementEntity = productMapper.PRODUCT_ENTITY(announcement);
            ProductEntity updatedAnnouncementEntity = productoRepository.save(announcementEntity);
            return Optional.of(productMapper.PRODUCTO(updatedAnnouncementEntity));
        }
        return  Optional.empty();
    }

    @Override
    public boolean deleteById(Long id) {
        if (productoRepository.existsById(id)){
            productoRepository.deleteById(id);
            return true;
        }
        return  false;
    }
}
