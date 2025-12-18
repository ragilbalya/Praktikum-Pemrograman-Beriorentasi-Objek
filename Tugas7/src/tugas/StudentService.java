package tugas;

import java.util.*;

public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public void createStudent(String npm, String name, double gpa) {
        if (repo.findByNpm(npm) != null)
            throw new IllegalArgumentException("NPM sudah digunakan!");

        if (gpa < 0 || gpa > 4)
            throw new IllegalArgumentException("GPA harus 0 - 4");

        repo.add(new Student(npm, name, gpa));
    }

    public List<Student> getAllSorted() {
        List<Student> data = repo.getAll();
        data.sort(Comparator.comparing(Student::getNpm));
        return data;
    }

    public Student findByNpm(String npm) { return repo.findByNpm(npm); }

    public List<Student> searchByName(String name) { return repo.findByName(name); }

    public boolean updateStudent(String npm, String name, double gpa) {
        Student s = repo.findByNpm(npm);
        if (s == null) return false;

        return repo.update(npm, new Student(npm, name, gpa));
    }

    public boolean deleteStudent(String npm) { return repo.remove(npm); }

    // Pagination
    public List<Student> getPage(int page, int size) {
        List<Student> data = repo.getAll();
        int from = (page - 1) * size;
        int to = Math.min(from + size, data.size());

        if (from >= data.size()) return Collections.emptyList();
        return data.subList(from, to);
    }

    // FIX untuk CSV, biar tidak error "repo private"
    public void exportCsv(String path) { repo.saveToCsv(path); }
    public void importCsv(String path) { repo.loadFromCsv(path); }
}