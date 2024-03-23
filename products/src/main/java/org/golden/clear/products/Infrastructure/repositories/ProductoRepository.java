package org.golden.clear.products.Infrastructure.repositories;

import org.golden.clear.products.Infrastructure.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductoRepository extends JpaRepository<ProductEntity, Long> {
}
