package pe.edu.vallegrande.app.service.impl;

import pe.edu.vallegrande.app.model.Product;
import pe.edu.vallegrande.app.repository.ProductRepository;
import pe.edu.vallegrande.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Flux<Product> findAll() {
        log.info("Mostrando productos");
        return productRepository.findAll();
    }

    @Override
    public Mono<Product> findById(String id) {
        log.info("Mostrando producto por ID: " + id);
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> save(Product product) {
        log.info("Registrando producto: " + product.toString());
        product.setState("A");
        return productRepository.save(product);
    }

    @Override
    public Mono<Product> update(Product product) {
        log.info("Actualizando producto: " + product.toString());
        return productRepository.save(product);
    }

    @Override
    public Mono<Void> delete(String id) {
        log.info("Eliminando producto con ID: " + id);
        return productRepository.deleteById(id);
    }

    @Override
    public Flux<Product> findByState(String state) {
        log.info("Listando productos por estado: " + state);
        return productRepository.findByState(state);
    }

}
