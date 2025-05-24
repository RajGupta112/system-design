package solidPrincipal;

import java.util.ArrayList;
import java.util.List;

interface Account{
    void deposit(double amount);
    void withdraw(double amount);
}
class SavingAccount implements Account{
   private double balance;
    public SavingAccount(){
        double balance = 0;
    }


    @Override
    public void deposit(double amount) {
        balance=balance+amount;
        System.out.println("Deposited"+amount+"in saving Account"+balance);
    }

    @Override
    public void withdraw(double amount) {
        if(balance>amount){
        balance=balance+amount;
        System.out.println("withdrawal"+amount+"in saving Account"+balance);
    }else {
            System.out.println("insufficient amount");
        }
    }
}

class CurrentAccount implements Account{
    private  double balance;

    @Override
    public void deposit(double amount) {
        balance=balance+amount;
        System.out.println("Deposited"+amount+"in current Account"+balance);
    }

    @Override
    public void withdraw(double amount) {
        if(balance>amount){
            balance=balance+amount;
            System.out.println("withdrawal"+amount+"in current Account"+balance);
        }else {
            System.out.println("insufficient amount");
        }
    }

}

class FixedAccount implements  Account{
    private  double balance;

    @Override
    public void deposit(double amount) {
        balance=balance+amount;
        System.out.println("Deposited"+amount+"in fixed Account"+balance);
    }

    @Override
    public void withdraw(double amount) {
     throw  new UnsupportedOperationException(" withdrawal not allowed in fixed");
    }
}
class BankClient2{
    private List<Account> accounts;
    public BankClient2(List<Account> accounts) {
        this.accounts = accounts;
    }
    public void processsTransaction(){
        for (Account c:accounts){
            c.deposit(599);
            try{
                c.withdraw(500);
            }catch (UnsupportedOperationException e){
                System.out.println("Exception"+e.getMessage());
            }
        }
    }
}

public class LcpVoileted {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new SavingAccount());
        accounts.add(new CurrentAccount());
        accounts.add(new FixedAccount());

        BankClient2 client = new BankClient2(accounts);
        client.processsTransaction(); // Throws exception when withdrawing from FixedTermAccount
    }
}

