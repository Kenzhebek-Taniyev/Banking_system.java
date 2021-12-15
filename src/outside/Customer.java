package outside;

import banking_system.Bank;

public class Customer {
    Bank bank;
    int myCode = -123;

    public Customer (Bank bank) {
        this.bank = bank;
    }

    public void openAccount() {
        if (this.myCode == -123) myCode = bank.createAccount(); //to avoid opening new account twice
    }

    public void depositMoney(int amount) {
        bank.getAtm().loginToAccount(myCode);
        bank.getAtm().deposit(amount);
        bank.getAtm().logout();
    }

    public void withdrawMoney(int amount) {
        bank.getAtm().loginToAccount(myCode);
        bank.getAtm().withdraw(amount);
        bank.getAtm().logout();
    }

    public int checkBalance() {
        bank.getAtm().loginToAccount(myCode);
        int balance = bank.getAtm().getBalance();
        bank.getAtm().logout();
        return balance;
    }
}
