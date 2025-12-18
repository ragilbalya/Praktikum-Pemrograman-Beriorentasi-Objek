package tugas.tax;

public class ProgressiveTaxCalculator implements TaxCalculator {

    @Override
    public double calculate(double income) {
        if (income <= 5000000) {
            return income * 0.10;
        } else {
            return (5000000 * 0.10) + ((income - 5000000) * 0.20);
        }
    }
}