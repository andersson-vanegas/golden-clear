package org.golden.clear.products.Application.usecases;

import org.golden.clear.products.Domain.models.Producto;
import org.golden.clear.products.Domain.ports.in.RetrieveProductUseCase;
import org.golden.clear.products.Domain.ports.out.ProductRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;


    public RetrieveProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }


    @Override
    public Optional<Producto> getProductById(Long id) {
        return productRepositoryPort.findById(id);
    }

    @Override
    public List<Producto> getAllProducts() {
        return productRepositoryPort.findAll();
    }
}
