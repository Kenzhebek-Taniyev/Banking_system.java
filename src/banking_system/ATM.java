package banking_system;

public class ATM {
    //it should have a field holding onto a Bank
    //reference, which should be passed into its constructor when created.
    private final Bank bank;
    private int loggedAccount;
    private boolean loggedIn;

    ATM (Bank bank) {
        this.bank = bank;
        this.loggedIn = false;
        this.loggedAccount = -1;
    }

    public boolean loginToAccount(int acctNum) {
        if (bank.getAccountCode() <= acctNum || acctNum < 0) {
            return false;
        }
        else {
            this.loggedIn = true;
            this.loggedAccount = acctNum;
            return true;
        }
    }

    public boolean deposit(int amount) {
        if (loggedIn) {
            try {
                bank.updateAcctBal(loggedAccount, amount);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
        else return false;
    }

    /** deposit() and withdraw() is absolute same
    *
     **/
    public boolean withdraw(int amount) {
        if (loggedIn) {
            try {
                bank.updateAcctBal(loggedAccount, -amount);
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
        else return false;
    }

    public int getBalance() {
        if (loggedIn) {
            try {
                return bank.accessAcctInfo(loggedAccount);
            } catch (Exception ex) {
                return -1;
            }
        }
        else return 0;
    }

    public void logout() {
        loggedIn = false;
        loggedAccount = -1;
    }
}
