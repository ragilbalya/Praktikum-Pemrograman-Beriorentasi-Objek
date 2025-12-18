package com.example.demo.tugas.controller;

import com.example.demo.tugas.dto.StudentRequest;
import com.example.demo.tugas.model.Student;
import com.example.demo.tugas.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<Student> create(@Valid @RequestBody StudentRequest req) {
        return ResponseEntity.ok(service.create(req));
    }

    @PutMapping("/{npm}")
    public ResponseEntity<Student> update(
            @PathVariable String npm,
            @Valid @RequestBody StudentRequest req
    ) {
        return ResponseEntity.ok(service.update(npm, req));
    }

    @DeleteMapping("/{npm}")
    public ResponseEntity<Void> delete(@PathVariable String npm) {
        service.delete(npm);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return service.searchByName(name);
    }
}