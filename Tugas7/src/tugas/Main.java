package tugas;

public class Main {
    public static void main(String[] args) {
        StudentRepository repo = new StudentRepository();
        StudentService service = new StudentService(repo);
        StudentController ui = new StudentController(service);

        // contoh data awal
        service.createStudent("210101", "Siti", 3.8);
        service.createStudent("210102", "Agus", 3.2);

        ui.start();
    }
}