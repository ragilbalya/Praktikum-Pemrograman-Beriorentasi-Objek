package Latihan;

class Staff extends Employee {
    public Staff(String name, double salary) {
        super(name, salary);
    }

    @Override
    public double calculateBonus() {
        return 0.05 * salary;
    }
}