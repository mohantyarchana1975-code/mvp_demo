package com.demo.mvp;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepo repo;
    public ProductController(ProductRepo repo){this.repo=repo;}
    @GetMapping public List<Product> all(){ return repo.findAll(); }
    @PostMapping public Product create(@RequestBody Product p){ return repo.save(p); }
}