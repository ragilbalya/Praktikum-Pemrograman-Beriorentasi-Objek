package latihan;

public class MainLatihan {

    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Nabil", 100000);

        try {
            System.out.println("Menarik 150000...");
            acc.withdraw(150000);

        } catch (InsufficientFundsException e) {
            System.out.println("GAGAL: " + e.getMessage());
        }

        System.out.println("Saldo akhir: " + acc.getBalance());
    }
}