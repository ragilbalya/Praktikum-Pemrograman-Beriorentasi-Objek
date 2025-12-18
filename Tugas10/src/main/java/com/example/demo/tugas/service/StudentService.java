package main.java.com.example.demo.tugas.service;

import com.example.demo.tugas.dto.StudentRequest;
import com.example.demo.tugas.model.Student;
import main.java.com.example.demo.tugas.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<Student> getAll() {
        return repo.findAll();
    }

    public Student create(StudentRequest req) {
        if (repo.existsById(req.getNpm())) {
            throw new IllegalArgumentException("NPM sudah terdaftar!");
        }

        Student s = new Student(
                req.getNpm(),
                req.getName(),
                req.getGpa()
        );

        return repo.save(s);
    }

    public Student update(String npm, StudentRequest req) {
        Student s = repo.findById(npm)
                .orElseThrow(() -> new IllegalArgumentException("Data tidak ditemukan"));

        s.setName(req.getName());
        s.setGpa(req.getGpa());

        return repo.save(s);
    }

    public void delete(String npm) {
        repo.deleteById(npm);
    }

    public List<Student> searchByName(String name) {
        return repo.findByNameContainingIgnoreCase(name);
    }
}