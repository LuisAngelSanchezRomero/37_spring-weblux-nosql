package pe.edu.vallegrande.app.repository;

import pe.edu.vallegrande.app.model.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

    Flux<Product> findByState(String state);

}
