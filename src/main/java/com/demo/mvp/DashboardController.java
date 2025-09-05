package com.demo.mvp;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    private final ProductRepo products; private final SupplierRepo suppliers; private final PORepo pos; private final InventoryRepo inv;
    public DashboardController(ProductRepo products, SupplierRepo suppliers, PORepo pos, InventoryRepo inv){
        this.products=products; this.suppliers=suppliers; this.pos=pos; this.inv=inv;
    }
    @GetMapping("/metrics")
    public Map<String,Object> metrics(){
        int stock = inv.findAll().stream().mapToInt(InventoryRecord::getDelta).sum();
        return Map.of(
            "products", products.count(),
            "suppliers", suppliers.count(),
            "purchaseOrders", pos.count(),
            "stock", stock
        );
    }
}