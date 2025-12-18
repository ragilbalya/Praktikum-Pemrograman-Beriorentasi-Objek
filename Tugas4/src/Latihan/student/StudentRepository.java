package Latihan.student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public void add(Student s) {
        students.add(s);
    }

    // 1. searchByName
    public List<Student> searchByName(String partial) {
        String key = partial.toLowerCase();
        List<Student> result = new ArrayList<>();

        for (Student s : students) {
            if (s.getName().toLowerCase().contains(key)) {
                result.add(s);
            }
        }
        return result;
    }

    // 2. paginate
    public List<Student> paginate(int page, int size) {
        int start = (page - 1) * size;
        int end = Math.min(start + size, students.size());

        if (start >= students.size() || start < 0) {
            return new ArrayList<>();
        }
        return new ArrayList<>(students.subList(start, end));
    }
}