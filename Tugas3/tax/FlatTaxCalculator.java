package tugas.tax;

public class FlatTaxCalculator implements TaxCalculator {

    private double rate;

    public FlatTaxCalculator(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculate(double income) {
        return income * rate;
    }
}