package tugas;

import java.io.*;
import java.util.*;

public class StudentRepository {

    private final List<Student> students = new ArrayList<>();

    public void add(Student s) {
        students.add(s);
    }

    public Student findByNpm(String npm) {
        for (Student s : students) {
            if (s.getNpm().equals(npm)) return s;
        }
        return null;
    }

    public List<Student> findByName(String partial) {
        String p = partial.toLowerCase();
        List<Student> result = new ArrayList<>();
        for (Student s : students) {
            if (s.getName().toLowerCase().contains(p)) result.add(s);
        }
        return result;
    }

    public boolean update(String npm, Student newData) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getNpm().equals(npm)) {
                students.set(i, newData);
                return true;
            }
        }
        return false;
    }

    public boolean remove(String npm) {
        return students.removeIf(s -> s.getNpm().equals(npm));
    }

    public List<Student> getAll() {
        return new ArrayList<>(students);
    }

    // =========================
    // CSV EXPORT
    // =========================
    public void saveToCsv(String path) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (Student s : students) {
                pw.println(s.getNpm() + "," + s.getName() + "," + s.getGpa());
            }
            System.out.println("CSV berhasil disimpan.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan CSV: " + e.getMessage());
        }
    }

    // =========================
    // CSV IMPORT
    // =========================
    public void loadFromCsv(String path) {
        students.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] p = line.split(",");
                if (p.length == 3) {
                    students.add(new Student(p[0], p[1], Double.parseDouble(p[2])));
                }
            }
            System.out.println("CSV berhasil dimuat.");
        } catch (IOException e) {
            System.out.println("Gagal memuat CSV: " + e.getMessage());
        }
    }
}