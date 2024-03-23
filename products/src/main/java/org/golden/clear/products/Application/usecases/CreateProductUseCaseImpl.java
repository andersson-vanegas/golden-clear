package org.golden.clear.products.Application.usecases;

import org.golden.clear.products.Domain.models.Producto;
import org.golden.clear.products.Domain.ports.in.CreateProductUseCase;
import org.golden.clear.products.Domain.ports.out.ProductRepositoryPort;

public class CreateProductUseCaseImpl implements CreateProductUseCase {


    private final ProductRepositoryPort productRepositoryPort;

    public CreateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Producto createProduct(Producto producto) {
        return productRepositoryPort.save(producto);
    }
}
