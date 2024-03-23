package org.golden.clear.products.Domain.ports.in;

import org.golden.clear.products.Domain.models.Producto;

import java.util.List;
import java.util.Optional;

public interface RetrieveProductUseCase {

    Optional<Producto> getProductById(Long id);

    List<Producto> getAllProducts();
}
