package model;

import javafx.beans.property.*;

public class Student {

    private final StringProperty npm = new SimpleStringProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final DoubleProperty gpa = new SimpleDoubleProperty();

    public Student(String npm, String name, double gpa) {
        this.npm.set(npm);
        this.name.set(name);
        this.gpa.set(gpa);
    }

    public String getNpm() { return npm.get(); }
    public StringProperty npmProperty() { return npm; }

    public String getName() { return name.get(); }
    public void setName(String n) { name.set(n); }
    public StringProperty nameProperty() { return name; }

    public double getGpa() { return gpa.get(); }
    public void setGpa(double g) { gpa.set(g); }
    public DoubleProperty gpaProperty() { return gpa; }
}