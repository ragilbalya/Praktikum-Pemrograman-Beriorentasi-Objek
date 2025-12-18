package Latihan;

class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String make, String model, int year, boolean hasSidecar) {
        super(make, model, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public String getInfo() {
        return "Motorcycle: " + make + " " + model + " (" + year + "), Sidecar: " + hasSidecar;
    }
}