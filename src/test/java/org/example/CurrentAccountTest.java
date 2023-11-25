package org.example;

import org.example.Account;
import org.example.CurrentAccount;
import org.example.UserInformation;
import org.junit.Assert;
import org.junit.Test;
import java.util.Date;



public class CurrentAccountTest {

    @Test
    public void testConstructor() {
        UserInformation user = new UserInformation("Johnson", "Baby", "johnson.baby@example.com", "1234567890", "123456789", "Hasthinapuram St", "Engineer", "Male", new Date(2000, 1, 1));
        CurrentAccount currentAccount = new CurrentAccount(user);

        Assert.assertEquals(1000, currentAccount.getBalance(), 0.0001);
    }

    @Test
    public void testParaConstructor() {
        UserInformation user = new UserInformation("Jackie", "Chan", "jackie.Chan@example.com", "9876543240", "9876534321", "Rocketer street", "Doctor", "Female", new Date(1995, 5, 15));
        CurrentAccount currentAccount = new CurrentAccount("123456789", "4321", 2000, user);

        // Check if the account number, PIN, and balance are set correctly
        Assert.assertEquals("123456789", currentAccount.getAccountNo());
        Assert.assertEquals("4321", currentAccount.getPIN());
        Assert.assertEquals(2000, currentAccount.getBalance(), 0.0001);
    }

    @Test
    public void testMinBalance() {
        UserInformation user = new UserInformation("Samuel", "Johnson", "samuel.johnson@example.com", "11123411111", "1134511111", "Hyderabad", "Artist", "male", new Date(1980, 10, 20));
        CurrentAccount currentAccount = new CurrentAccount(user);

        currentAccount.setMinBalance(1500);

        Assert.assertEquals(1500, currentAccount.getMinBalance());
    }

    @Test
    public void testWithdrawalLimit() {
        UserInformation user = new UserInformation("Bob", "Miller", "bob.miller@example.com", "2222222222", "222222222", "321 Elm St", "Teacher", "Male", new Date(1975, 8, 5));
        CurrentAccount currentAccount = new CurrentAccount(user);

        currentAccount.setWithdrawalLimit(200, 1000);
        Assert.assertEquals(200, currentAccount.getMinWithdrawal());
        Assert.assertEquals(1000, currentAccount.getMaxWithdrawal());
    }

    @Test
    public void testGetAccountType() {
        UserInformation user = new UserInformation("J", "D", "j.d@example.com", "9090909090", "124456789", "123 Main St", "Engineer", "Male", new Date(2001, 1, 1));
        CurrentAccount currentAccount = new CurrentAccount(user);

        Assert.assertEquals(Account.CURRENT_ACCOUNT, currentAccount.getAccountType());
    }
}