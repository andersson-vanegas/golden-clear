package org.golden.clear.products.Infrastructure.config;

import org.golden.clear.products.Application.services.ProductService;
import org.golden.clear.products.Application.usecases.CreateProductUseCaseImpl;
import org.golden.clear.products.Application.usecases.DeleteProductUseCaseImpl;
import org.golden.clear.products.Application.usecases.RetrieveProductUseCaseImpl;
import org.golden.clear.products.Application.usecases.UpdateProductUseCaseImpl;
import org.golden.clear.products.Domain.ports.out.ProductRepositoryPort;
import org.golden.clear.products.Infrastructure.adapters.JpaProductAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {


    @Bean
    public ProductService productService(ProductRepositoryPort productRepositoryPort){
        return  new ProductService(
                new CreateProductUseCaseImpl(productRepositoryPort),
                new DeleteProductUseCaseImpl( productRepositoryPort),
                new RetrieveProductUseCaseImpl(productRepositoryPort),
                new UpdateProductUseCaseImpl(productRepositoryPort)
        );
    }

    @Bean
    public ProductRepositoryPort productRepositoryPort(JpaProductAdapter jpaProductAdapter){
        return  jpaProductAdapter;
    }
}
