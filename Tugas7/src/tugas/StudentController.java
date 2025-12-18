package tugas;

import java.util.List;
import java.util.Scanner;

public class StudentController {

    private final StudentService service;
    private final Scanner sc = new Scanner(System.in);

    public StudentController(StudentService service) {
        this.service = service;
    }

    public void start() {
        while (true) {
            menu();
            String c = sc.nextLine().trim();

            switch (c) {
                case "1": add(); break;
                case "2": list(); break;
                case "3": searchByNpm(); break;
                case "4": searchByName(); break;
                case "5": update(); break;
                case "6": delete(); break;
                case "7": pagination(); break;
                case "8": exportCsv(); break;
                case "9": importCsv(); break;
                case "0":
                    System.out.println("Keluar...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private void menu() {
        System.out.println("\n=== MENU MAHASISWA ===");
        System.out.println("1. Tambah Mahasiswa");
        System.out.println("2. Lihat Semua Mahasiswa");
        System.out.println("3. Cari Mahasiswa (NPM)");
        System.out.println("4. Cari Mahasiswa (Nama)");
        System.out.println("5. Update Mahasiswa");
        System.out.println("6. Hapus Mahasiswa");
        System.out.println("7. Pagination");
        System.out.println("8. Export CSV");
        System.out.println("9. Import CSV");
        System.out.println("0. Keluar");
        System.out.print("Pilih > ");
    }

    private void add() {
        try {
            System.out.print("NPM: ");
            String npm = sc.nextLine();

            System.out.print("Nama: ");
            String name = sc.nextLine();

            System.out.print("GPA: ");
            double gpa = Double.parseDouble(sc.nextLine());

            service.createStudent(npm, name, gpa);
            System.out.println("✔ Mahasiswa berhasil ditambahkan.");
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private void list() {
        List<Student> list = service.getAllSorted();

        if (list.isEmpty()) {
            System.out.println("Data kosong.");
        } else {
            list.forEach(System.out::println);
        }
    }

    private void searchByNpm() {
        System.out.print("Masukkan NPM: ");
        String npm = sc.nextLine();

        Student s = service.findByNpm(npm);
        System.out.println(s == null ? "Tidak ditemukan." : s);
    }

    private void searchByName() {
        System.out.print("Masukkan nama: ");
        String name = sc.nextLine();

        List<Student> result = service.searchByName(name);
        if (result.isEmpty()) System.out.println("Tidak ada hasil.");
        else result.forEach(System.out::println);
    }

    private void update() {
        try {
            System.out.print("NPM: ");
            String npm = sc.nextLine();

            System.out.print("Nama baru: ");
            String name = sc.nextLine();

            System.out.print("GPA baru: ");
            double gpa = Double.parseDouble(sc.nextLine());

            boolean ok = service.updateStudent(npm, name, gpa);
            System.out.println(ok ? "✔ Update berhasil." : "❌ Mahasiswa tidak ditemukan.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void delete() {
        System.out.print("NPM: ");
        String npm = sc.nextLine();

        boolean ok = service.deleteStudent(npm);
        System.out.println(ok ? "✔ Hapus berhasil." : "❌ Mahasiswa tidak ditemukan.");
    }

    private void pagination() {
        try {
            System.out.print("Halaman (page): ");
            int page = Integer.parseInt(sc.nextLine());

            System.out.print("Jumlah per halaman (size): ");
            int size = Integer.parseInt(sc.nextLine());

            List<Student> data = service.getPage(page, size);
            if (data.isEmpty()) System.out.println("Halaman kosong.");
            else data.forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("Input salah!");
        }
    }

    private void exportCsv() {
        System.out.print("Nama file CSV (mis: data.csv): ");
        String file = sc.nextLine();

        service.exportCsv(file);
    }

    private void importCsv() {
        System.out.print("Nama file CSV: ");
        String file = sc.nextLine();

        service.importCsv(file);
    }
}