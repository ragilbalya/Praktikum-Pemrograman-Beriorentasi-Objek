package Latihan.student;

public class Main {
    public static void main(String[] args) {

        StudentRepository repo = new StudentRepository();

        repo.add(new Student("Budi"));
        repo.add(new Student("Sabrina"));
        repo.add(new Student("Ani"));
        repo.add(new Student("Anisa"));

        System.out.println(repo.searchByName("ni"));
        System.out.println(repo.paginate(1, 2));
    }
}