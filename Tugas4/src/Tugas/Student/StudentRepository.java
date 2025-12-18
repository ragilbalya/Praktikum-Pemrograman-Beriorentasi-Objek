package Tugas.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentRepository {

    private final List<Student> students = new ArrayList<>();
    private final List<Student> logs = new ArrayList<>();

    public void add(Student s) {
        students.add(s);
    }

    public void update(int id, String newName) {
        for (Student s : students) {
            if (s.getId() == id) {

                logs.add(new Student(s)); // simpan copy sebelum perubahan

                students.set(students.indexOf(s), new Student(id, newName));
                return;
            }
        }
    }

    public void remove(int id) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getId() == id) {

                logs.add(new Student(s)); // copy

                it.remove();
                return;
            }
        }
    }

    // defensive copy log
    public List<Student> getLogs() {
        List<Student> copy = new ArrayList<>();
        for (Student s : logs) {
            copy.add(new Student(s));
        }
        return copy;
    }
}