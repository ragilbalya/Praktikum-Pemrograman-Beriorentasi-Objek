package Latihan;

public class MainA {
    public static void main(String[] args) {
        Vehicle[] garage = {
                new Car("Toyota", "Avanza", 2015, 4),
                new Motorcycle("Honda", "CBR", 2020, false),
                new Car("Suzuki", "Ertiga", 2018, 5)
        };

        for (Vehicle v : garage) {
            System.out.println(v.getInfo()); // polymorphism
        }
    }
}