package banking_system;

public class Bank {
    private Account accounts[];
    private final ATM atm;
    private int accountCode = 0;

    public Bank() {
        this.accounts = new Account[100];

        atm = new ATM(this);
    }

    /**
     *Called by Customer
     * @return account number
    */


    public int createAccount() {
        accounts[accountCode] = new Account(accountCode);
        accountCode++;
        return accountCode-1;
    }

    /**
     *Called by Customer
     * @return ATM
     */
    public ATM getAtm() {
        return atm;
    }

    /**
     *Called by an ATM
     * @return current balance
     */
    public int accessAcctInfo(int AcctNum) throws Exception {
        if (AcctNum >= accountCode || AcctNum < 0) {
            throw new Exception("Account number has no corresponding Account");
        }
        else {
            return accounts[AcctNum].getAccountBalance();
        }
    }

    /**
     *Called by an ATM
     * Update balance
     *
     * @param acctNum, and balance to add
     */
    public void updateAcctBal(int acctNum, int diff) throws Exception {
        if (acctNum >= accountCode || acctNum < 0) {
            throw new Exception("Account number has no corresponding Account");
        }
        else {
            if (accounts[acctNum].getAccountBalance() + diff < 0) {
                throw new Exception("Resulting balance is negative");
            }
            else {
                accounts[acctNum].addBalance(diff);
            }
        }
    }

    int getAccountCode() {
        return accountCode;
    }


}
