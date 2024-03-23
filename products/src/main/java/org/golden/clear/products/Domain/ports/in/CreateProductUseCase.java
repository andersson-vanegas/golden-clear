package org.golden.clear.products.Domain.ports.in;

import org.golden.clear.products.Domain.models.Producto;

public interface CreateProductUseCase {

    Producto createProduct (Producto  producto);

}
