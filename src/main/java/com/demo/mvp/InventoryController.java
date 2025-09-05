package com.demo.mvp;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private final InventoryRepo repo;
    public InventoryController(InventoryRepo repo){this.repo=repo;}
    @GetMapping public List<InventoryRecord> all(){ return repo.findAll(); }
}