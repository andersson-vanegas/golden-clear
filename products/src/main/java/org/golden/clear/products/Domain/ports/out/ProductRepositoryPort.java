package org.golden.clear.products.Domain.ports.out;

import org.golden.clear.products.Domain.models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {

    Producto save (Producto producto);

    Optional<Producto> findById (Long id);

    List<Producto> findAll();

    Optional <Producto> update (Producto announcement);
    boolean deleteById(Long id);

}
