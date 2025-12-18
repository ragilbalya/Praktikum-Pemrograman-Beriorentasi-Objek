package tugas.tax;

public class Employee {

    private String name;
    private double income;
    private TaxCalculator calculator;

    public Employee(String name, double income, TaxCalculator calculator) {
        this.name = name;
        this.income = income;
        this.calculator = calculator;
    }

    public void printTax() {
        double tax = calculator.calculate(income);
        System.out.println("Karyawan: " + name);
        System.out.println("Pendapatan: " + income);
        System.out.println("Pajak: " + tax);
    }
}