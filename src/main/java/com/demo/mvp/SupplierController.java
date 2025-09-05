package com.demo.mvp;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {
    private final SupplierRepo repo;
    public SupplierController(SupplierRepo repo){this.repo=repo;}
    @GetMapping public List<Supplier> all(){ return repo.findAll(); }
}