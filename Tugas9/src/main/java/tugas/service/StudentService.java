package main.java.tugas.service;

import main.java.tugas.model.Student;
import java.util.LinkedHashMap;
import java.util.Map;

public class StudentService {

    private final Map<String, Student> store = new LinkedHashMap<>();

    public Student createStudent(String npm, String name, double gpa) {
        if (store.containsKey(npm))
            throw new IllegalArgumentException("NPM sudah terdaftar.");

        Student s = new Student(npm, name, gpa);
        store.put(npm, s);
        return s;
    }

    public void delete(String npm) {
        store.remove(npm);
    }
}