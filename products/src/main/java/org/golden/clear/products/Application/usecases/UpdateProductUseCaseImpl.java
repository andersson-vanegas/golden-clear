package org.golden.clear.products.Application.usecases;

import org.golden.clear.products.Domain.models.Producto;
import org.golden.clear.products.Domain.ports.in.UpdateProductUseCase;
import org.golden.clear.products.Domain.ports.out.ProductRepositoryPort;

import java.util.Optional;

public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public UpdateProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto) {
        return productRepositoryPort.update(producto);
    }
}
