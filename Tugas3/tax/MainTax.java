package Tugas3.tax;

public class MainTax {

    public static void main(String[] args) {

        TaxCalculator flat = new FlatTaxCalculator(0.10);
        TaxCalculator progressive = new ProgressiveTaxCalculator();

        Employee e1 = new Employee("Budi", 4000000, flat);
        Employee e2 = new Employee("Siti", 8000000, progressive);

        e1.printTax();
        System.out.println();
        e2.printTax();
    }
}