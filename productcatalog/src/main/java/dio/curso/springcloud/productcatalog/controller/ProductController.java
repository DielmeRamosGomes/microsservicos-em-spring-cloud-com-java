package dio.curso.springcloud.productcatalog.controller;

import dio.curso.springcloud.productcatalog.model.Product;
import dio.curso.springcloud.productcatalog.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(final ProductRepository repository) {
        this.productRepository = repository;
    }

    @RequestMapping(method = RequestMethod.POST)
    Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Optional<Product> findById(@PathVariable Long id) {
        return productRepository.findById(id);
    }


}
