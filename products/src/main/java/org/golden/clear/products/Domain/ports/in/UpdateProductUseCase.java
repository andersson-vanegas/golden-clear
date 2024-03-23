package org.golden.clear.products.Domain.ports.in;

import org.golden.clear.products.Domain.models.Producto;

import java.util.Optional;

public interface UpdateProductUseCase {

    Optional<Producto> updateProducto(Long id, Producto producto);
}
