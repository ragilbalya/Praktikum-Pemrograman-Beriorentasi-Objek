package latihan.service;

import model.Student;

import java.util.*;

public class StudentService {

    private final Map<String, Student> store = new LinkedHashMap<>();

    public Student createStudent(String npm, String name, double gpa) {
        if (store.containsKey(npm))
            throw new IllegalArgumentException("NPM sudah terdaftar.");

        Student s = new Student(npm, name, gpa);
        store.put(npm, s);
        return s;
    }

    public void deleteStudent(String npm) {
        store.remove(npm);
    }

    public void updateStudent(String npm, String name, double gpa) {
        Student s = store.get(npm);
        if (s == null) throw new IllegalArgumentException("Data tidak ditemukan.");

        s.setName(name);
        s.setGpa(gpa);
    }
}