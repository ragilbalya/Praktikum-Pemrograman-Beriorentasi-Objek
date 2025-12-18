package Tugas;

import java.util.HashMap;
import java.util.Map;

public class Bank2 {
    private Map<String, BankAccount2> accounts = new HashMap<>();

    public void createAccount(String accNumber, String ownerName, double initialBalance) {
        if (accounts.containsKey(accNumber))
            throw new IllegalArgumentException("Account already exists");

        accounts.put(accNumber, new BankAccount2(accNumber, ownerName, initialBalance));
    }

    public BankAccount2 findAccount(String accNumber) {
        return accounts.get(accNumber);
    }

    public void transfer(String fromAcc, String toAcc, double amount) {
        BankAccount2 from = accounts.get(fromAcc);
        BankAccount2 to   = accounts.get(toAcc);

        if (from == null || to == null)
            throw new IllegalArgumentException("Account not found");

        from.withdraw(amount);
        to.deposit(amount);
    }
}