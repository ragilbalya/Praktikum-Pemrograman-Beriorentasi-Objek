package latihan;

public class BankAccount {

    private String owner;
    private double balance;

    public BankAccount(String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(
                    "Saldo tidak cukup. Saldo: " + balance + ", diminta: " + amount
            );
        }
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}