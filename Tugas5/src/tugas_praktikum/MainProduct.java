package tugas_praktikum;

public class MainProduct {
    public static void main(String[] args) {
        ProductCatalog pc = new ProductCatalog();

        Product p1 = new Product("P001", "Gamepad", 150000);
        Product p2 = new Product("P002", "Mouse", 80000);

        pc.addProduct(p1);
        pc.addProduct(p2);

        System.out.println("Jumlah produk: " + pc.size());
        System.out.println("Ambil produk P001: " + pc.getProduct("P001").getName());

        pc.updateProduct("P001", "Mechanical Keyboard", 230000);
        System.out.println("Update P001: " + pc.getProduct("P001").getName());

        pc.removeProduct("P002");
        System.out.println("Jumlah produk setelah hapus: " + pc.size());
    }
}