package Tugas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount2 {
    private String accountNumber;
    private String ownerName;
    private double balance;

    // fitur tambahan (tugas opsional)
    private List<String> transactions = new ArrayList<>();

    public BankAccount2(String accountNumber, String ownerName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        setBalance(initialBalance);

        transactions.add("Account created with balance: " + initialBalance);
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
    public double getBalance() { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty())
            throw new IllegalArgumentException("Owner name cannot be empty");

        this.ownerName = ownerName;
        transactions.add("Owner name updated to: " + ownerName);
    }

    private void setBalance(double balance) {
        if (balance < 0)
            throw new IllegalArgumentException("Initial balance cannot be negative");

        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");

        balance += amount;
        transactions.add("Deposited: " + amount + " | New balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        if (amount > balance) throw new IllegalArgumentException("Insufficient funds");

        balance -= amount;
        transactions.add("Withdrew: " + amount + " | New balance: " + balance);
    }

    public List<String> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
}