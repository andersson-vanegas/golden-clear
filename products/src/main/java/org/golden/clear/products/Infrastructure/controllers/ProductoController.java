package org.golden.clear.products.Infrastructure.controllers;


import jakarta.validation.Valid;
import org.golden.clear.products.Application.services.ProductService;
import org.golden.clear.products.Domain.models.Producto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {


    private final ProductService productService;

    public ProductoController(ProductService productService) {
        this.productService = productService;
    }


    //CREAR PRODUCTO
    @PostMapping
    public ResponseEntity<Producto> createTask( @Valid @RequestBody Producto producto) {
        Producto createdProduct = productService.createProduct(producto);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }



    //OBTENER  PRODUCTO POR ID
    @GetMapping("/{Id}")
    public ResponseEntity<Producto> getProductById(@PathVariable Long Id) {
        return productService.getProductById(Id)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //OBTENER TODOS PRODUCTOS
    @GetMapping
    public ResponseEntity<List<Producto>> getAllProducts() {
        List<Producto> tasks = productService.getAllProducts();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }


    //ACTUALIZAR PRODUCTO
    @PutMapping("/{Id}")
    public ResponseEntity<Producto> updateProduct( @Valid @PathVariable Long Id, @RequestBody Producto producto) {
        return productService.updateProducto(Id, producto)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    //ELIMINAR PRODUCTO
    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long Id) {
        if (productService.deleteProduct(Id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
