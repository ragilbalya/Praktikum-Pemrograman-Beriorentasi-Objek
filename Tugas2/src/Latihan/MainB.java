package Latihan;

public class MainB {
    public static void main(String[] args) {
        Employee[] employees = {
                new Manager("Alice", 15000),
                new Staff("Bob", 5000)
        };

        double total = 0;
        for (Employee e : employees) {
            double bonus = e.calculateBonus();
            System.out.println(e.name + " Bonus: " + bonus);
            total += bonus;
        }

        System.out.println("Total Bonus: " + total);
    }
}