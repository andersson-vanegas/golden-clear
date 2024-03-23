package org.golden.clear.products.Application.usecases;

import org.golden.clear.products.Domain.ports.in.DeleteProductUseCase;
import org.golden.clear.products.Domain.ports.out.ProductRepositoryPort;

public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductRepositoryPort productRepositoryPort;

    public DeleteProductUseCaseImpl(ProductRepositoryPort productRepositoryPort) {
        this.productRepositoryPort = productRepositoryPort;
    }

    @Override
    public Boolean deleteProduct(Long id) {
        return productRepositoryPort.deleteById(id);
    }
}
