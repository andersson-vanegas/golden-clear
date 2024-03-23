package org.golden.clear.products.Application.services;

import org.golden.clear.products.Domain.models.Producto;
import org.golden.clear.products.Domain.ports.in.CreateProductUseCase;
import org.golden.clear.products.Domain.ports.in.DeleteProductUseCase;
import org.golden.clear.products.Domain.ports.in.RetrieveProductUseCase;
import org.golden.clear.products.Domain.ports.in.UpdateProductUseCase;

import java.util.List;
import java.util.Optional;

public class ProductService implements CreateProductUseCase, DeleteProductUseCase, RetrieveProductUseCase, UpdateProductUseCase {


    private final  CreateProductUseCase createProductUseCase;

    private final DeleteProductUseCase deleteProductUseCase;
    private final RetrieveProductUseCase retrieveProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;


    public ProductService(CreateProductUseCase createProductUseCase, DeleteProductUseCase deleteProductUseCase, RetrieveProductUseCase retrieveProductUseCase, UpdateProductUseCase updateProductUseCase) {
        this.createProductUseCase = createProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.retrieveProductUseCase = retrieveProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
    }

    @Override
    public Producto createProduct(Producto producto) {
        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (producto.getPrice() == null || producto.getPrice() <= 0) {
            throw new IllegalArgumentException("El precio no puede ser nulo o negativo");
        }

        return createProductUseCase.createProduct(producto);
    }

    @Override
    public Boolean deleteProduct(Long id) {
        return deleteProductUseCase.deleteProduct(id);
    }

    @Override
    public Optional<Producto> getProductById(Long id) {
        return retrieveProductUseCase.getProductById(id);
    }

    @Override
    public List<Producto> getAllProducts() {
        return retrieveProductUseCase.getAllProducts();
    }

    @Override
    public Optional<Producto> updateProducto(Long id, Producto producto)
    {
        retrieveProductUseCase.getProductById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));

        if (producto.getNombre() == null || producto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (producto.getPrice() == null || producto.getPrice() <= 0) {
            throw new IllegalArgumentException("El precio no puede ser nulo o negativo");
        }
        return updateProductUseCase.updateProducto(id, producto);
    }
}
