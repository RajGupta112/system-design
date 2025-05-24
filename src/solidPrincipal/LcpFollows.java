package solidPrincipal;

import java.util.ArrayList;
import java.util.List;

interface DepositAccount{
    void deposit( double amount);
}

interface WithdrawalAccount extends DepositAccount{
    void withdrawal(double amount);
}
class SavingAccount1 implements WithdrawalAccount{
    private double balance;

    public SavingAccount1() {
        balance = 0;
    }
    @Override
    public void withdrawal(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Savings Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Savings Account. New Balance: " + balance);
    }
}
class  CurrentAccount1 implements WithdrawalAccount{

    private double balance ;
    @Override
    public void withdrawal(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " from Current Account. New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Current Account!");
        }
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Current Account. New Balance: " + balance);
    }
}

class FixedAccount1 implements DepositAccount{

    private double balance;

    public FixedAccount1() {
        balance = 0;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + " in Fixed Term Account. New Balance: " + balance);
    }
}
class BankClient1 {
    private List<WithdrawalAccount> withdrawableAccounts;
    private List<DepositAccount> depositOnlyAccounts;

    public BankClient1(List<WithdrawalAccount> withdrawableAccounts,
                      List<DepositAccount> depositOnlyAccounts) {
        this.withdrawableAccounts = withdrawableAccounts;
        this.depositOnlyAccounts = depositOnlyAccounts;
    }

    public void processTransactions() {
        for (WithdrawalAccount acc : withdrawableAccounts) {
            acc.deposit(1000);
            acc.withdrawal(500);
        }
        for (DepositAccount acc : depositOnlyAccounts) {
            acc.deposit(5000);
        }
    }
}
public class LcpFollows {
    public static void main(String[] args) {
        List<WithdrawalAccount> withdrawableAccounts = new ArrayList<>();
        withdrawableAccounts.add(new SavingAccount1());
        withdrawableAccounts.add(new CurrentAccount1());

        List<DepositAccount> depositOnlyAccounts = new ArrayList<>();
        depositOnlyAccounts.add(new FixedAccount1());

        BankClient1 client = new BankClient1(withdrawableAccounts, depositOnlyAccounts);
        client.processTransactions();
    }
}
