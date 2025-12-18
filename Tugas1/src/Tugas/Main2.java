package Tugas;
public class Main2 {
    public static void main(String[] args) {

        Bank2 bank = new Bank2();

        bank.createAccount("A1", "Nabil", 1000);
        bank.createAccount("A2", "Rauf", 500);
        bank.createAccount("A3", "Alex", 200);

        bank.findAccount("A1").deposit(300);
        bank.findAccount("A2").withdraw(100);

        bank.transfer("A1", "A3", 250);

        // Cetak transaksi A1
        System.out.println("=== TRANSAKSI A1 ===");
        for (String t : bank.findAccount("A1").getTransactions()) {
            System.out.println(t);
        }

        // Cetak saldo akhir
        System.out.println("\n=== SALDO AKHIR ===");
        System.out.println("A1: " + bank.findAccount("A1").getBalance());
        System.out.println("A2: " + bank.findAccount("A2").getBalance());
        System.out.println("A3: " + bank.findAccount("A3").getBalance());
    }
}