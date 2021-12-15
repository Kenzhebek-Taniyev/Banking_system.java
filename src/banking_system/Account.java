package banking_system;

public class Account {
    private final int accountNumber;
    private int accountBalance;

    Account(int code) {
        accountNumber = code;
        accountBalance = 0;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void addBalance(int add) {
        this.accountBalance += add;
    }
}
