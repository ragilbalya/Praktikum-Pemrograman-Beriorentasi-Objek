package com.example.demo.tugas.dto;

import jakarta.validation.constraints.*;

public class StudentRequest {

    @NotBlank(message = "NPM wajib diisi")
    private String npm;

    @NotBlank(message = "Nama wajib diisi")
    private String name;

    @DecimalMin(value = "0.0", message = "GPA minimal 0.0")
    @DecimalMax(value = "4.0", message = "GPA maksimal 4.0")
    private Double gpa;

    public String getNpm() { return npm; }
    public void setNpm(String npm) { this.npm = npm; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getGpa() { return gpa; }
    public void setGpa(Double gpa) { this.gpa = gpa; }
}