package org.example;
import java.util.Random;

public abstract class Account
{
    public static final int SAVINGS_ACCOUNT=1;
    public static final int CURRENT_ACCOUNT=2;

    public static final int INSUFFICIENT_BALANCE=1;
    public static final int WITHDRAWAL_LIMIT_UNDER=2;
    public static final int WITHDRAWAL_LIMIT_OVER=3;

    public static final int WITHDRAWAL_LIMIT_EQUAL=4;

    private String accountNo;
    private String password;

    protected double balance;
    protected double minBalance;
    protected double minWithdrawal;
    protected double maxWithdrawal;

    protected UserInformation user;

    boolean isActivated;

    public Account(UserInformation u)
    {
        accountNo=generateUniqueAccountNumber();
        password=generatePIN();
        user=u;
    }

    public abstract void setMinBalance(double a);
    abstract void setWithdrawalLimit(double l, double h);
    abstract int getAccountType();

    public double getBalance()
    {
        return balance;
    }
    public void setBalance(double b)
    {
        balance=b;
    }

//    String getAccuntNo()
//    {
//        return accountNo;
//    }
    void setAccountNo(String s)
    {
        accountNo=s;
    }
    String getPIN()
    {
        return password;
    }
    void setPIN(String s)
    {
        password=s;
    }

    void activateAccount()
    {
        this.isActivated=true;
    }

    public String generateUniqueAccountNumber()
    {
        Random r = new Random();
        Database db = Database.getInstance();
        String accountNum=String.valueOf(r.nextInt(10000000)+89999999);
        if(db.isAccountNumberUnique(accountNum))
        {
            return accountNum;
        }
        return generateUniqueAccountNumber();
//        return "NULL";

    }
    public String generatePIN()
    {
        Random r = new Random();
        return String.valueOf(r.nextInt(1000)+8999);
    }

    public boolean payBill(double amount)
    {
        if(balance-amount<minBalance)
            return false;

        balance-=amount;
        return true;
    }

    public void depositMoney(double amount)
    {
        this.balance+=amount;
    }

    public boolean transferMoney(Account ac, double amount)
    {
        if(balance-amount<minBalance)
            return false;

        this.balance-=amount;
        ac.balance+=amount;
        return true;
    }

    int withdrawMoney(double amount)
    {
        if(amount<minWithdrawal)
            return WITHDRAWAL_LIMIT_UNDER;
        if(amount>maxWithdrawal)
            return WITHDRAWAL_LIMIT_OVER;
        if(amount == minWithdrawal)
            return WITHDRAWAL_LIMIT_EQUAL;
        if(balance-amount<minBalance)
            return INSUFFICIENT_BALANCE;

        balance-=amount;
        return 0;
    }

    public String toString()
    {
        return getAccountType()+"\n"+ accountNo + "\n" + password + "\n" + balance + "\n" + user + "\n" + isActivated + "\n";
    }

    public String getAccountNo() {
        return accountNo;
    }

    public int getMinBalance() {
        return (int) minBalance;
    }

    public int getMinWithdrawal() {
        return (int) minWithdrawal;
    }

    public int getMaxWithdrawal() {
        return (int) maxWithdrawal;
    }

}
