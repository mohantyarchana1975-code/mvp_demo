package com.demo.mvp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final UserRepo users; private final SupplierRepo suppliers; private final ProductRepo products;
    private final PORepo pos; private final InventoryRepo inv;
    public DataLoader(UserRepo users,SupplierRepo suppliers,ProductRepo products,PORepo pos,InventoryRepo inv){
        this.users=users; this.suppliers=suppliers; this.products=products; this.pos=pos; this.inv=inv;
    }
    @Override
    public void run(String... args) {
        users.save(new User("admin", "admin123", "Asha Admin", Role.ADMIN, "ADMIN_TOKEN"));
        users.save(new User("buyer", "buyer123", "Bobby Buyer", Role.BUYER, "BUYER_TOKEN"));
        users.save(new User("supplier", "supplier123", "Sara Supplier", Role.SUPPLIER, "SUPPLIER_TOKEN"));

        Supplier s1 = suppliers.save(new Supplier("Global Metals","active"));
        Supplier s2 = suppliers.save(new Supplier("Cosmo Cosmetics","active"));

        Product p1 = products.save(new Product("MET-001","Copper Sheets","Metals","kg", 8.75));
        Product p2 = products.save(new Product("EQP-002","Lab Mixer","Equipment","unit", 1200));
        Product p3 = products.save(new Product("COS-003","Aloe Cream","Cosmetics","box", 5.5));

        pos.save(new PurchaseOrder("PO-1001", s1, LocalDate.now().minusDays(10), OrderStatus.SENT));
        pos.save(new PurchaseOrder("PO-1002", s2, LocalDate.now().minusDays(3), OrderStatus.DRAFT));

        inv.save(new InventoryRecord(p1, 500, LocalDate.now().minusDays(12)));
        inv.save(new InventoryRecord(p2, -2, LocalDate.now().minusDays(5)));
        inv.save(new InventoryRecord(p3, 200, LocalDate.now().minusDays(2)));
        inv.save(new InventoryRecord(p1, -120, LocalDate.now().minusDays(1)));
    }
}
