package com.demo.mvp;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pos")
public class POController {
    private final PORepo repo;
    public POController(PORepo repo){this.repo=repo;}
    @GetMapping public List<PurchaseOrder> all(){ return repo.findAll(); }
    @PostMapping public PurchaseOrder create(@RequestBody PurchaseOrder po){ return repo.save(po); }
}