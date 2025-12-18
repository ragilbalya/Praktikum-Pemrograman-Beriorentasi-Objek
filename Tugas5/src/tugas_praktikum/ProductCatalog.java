package tugas_praktikum;

import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Product> catalog = new HashMap<String, Product>();

    public void addProduct(Product p) {
        catalog.put(p.getId(), p);
    }

    public void updateProduct(String id, String newName, double newPrice) {
        Product p = catalog.get(id);
        if (p != null) {
            p.setName(newName);
            p.setPrice(newPrice);
        }
    }

    public void removeProduct(String id) {
        catalog.remove(id);
    }

    public Product getProduct(String id) {
        return catalog.get(id);
    }

    public int size() {
        return catalog.size();
    }
}