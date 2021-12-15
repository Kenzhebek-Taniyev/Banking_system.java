package outside;

import banking_system.Bank;

public class Tester {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Customer Kenzhebek = new Customer(bank);
        Customer Altynbek  = new Customer(bank);

        Kenzhebek.openAccount();
        System.out.println(Kenzhebek.checkBalance());
        Kenzhebek.depositMoney(100);
        System.out.println(Kenzhebek.checkBalance());

        Altynbek.openAccount();
        Altynbek.depositMoney(150);
        System.out.println(Altynbek.checkBalance());
        Altynbek.withdrawMoney(100);
        Altynbek.withdrawMoney(100); //failed because balance is not enough
        System.out.println(Altynbek.checkBalance());
        Altynbek.openAccount(); //doesn't change anything because account already exists
        System.out.println(Altynbek.checkBalance());

        bank.getAtm().withdraw(133);
        //System.out.println(bank.getAccountCode()); //shouldn't work only banking_system can access
        //ATM Atm = new ATM(bank); //shouldn't work only banking_system can access
        //Account ac = new Account(123); //shouldn't work only banking_system can access
    }
}
