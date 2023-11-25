package org.example;

import org.example.Account;
import org.example.SavingsAccount;
import org.example.UserInformation;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class SavingsAccountTest {

    @Test
    public void testConstructor() {
        UserInformation user = new UserInformation("vamsi", "S", "vamsi.S@example.com", "1234567890", "123456789", "123 Chruch St", "Engineer", "Male", new Date(2000, 1, 1));
        SavingsAccount savingsAccount = new SavingsAccount(user);

        // Check if the initial balance is set correctly
        Assert.assertEquals(1200, savingsAccount.getBalance(), 0.0001);
    }

    @Test
    public void testParaConstructor() {
        UserInformation user =  new UserInformation("Dhoni", "Virat", "Dhoni.Virat@example.com", "9876543210", "987654321", "456 Jharkhand St", "Cricketer", "Male", new Date(1984, 5, 15));
        SavingsAccount savingsAccount = new SavingsAccount("123456789", "4321", 1000, user);

        // Check if the account number, PIN, and balance are set correctly
        Assert.assertEquals("123456789", savingsAccount.getAccountNo());
        Assert.assertEquals("4321", savingsAccount.getPIN());
        Assert.assertEquals(1000, savingsAccount.getBalance(), 0.0001);
    }

    @Test
    public void testMinBalance() {
        UserInformation user = new UserInformation("Ali", "Rashid", "Ali.Rashid@example.com", "1111111111", "111111111", "789 Pint", "Artist", "Female", new Date(1980, 10, 20));
        SavingsAccount savingsAccount = new SavingsAccount(user);

        // SetTing Minbalance
        savingsAccount.setMinBalance(1000);

        // Checking the Boundary value
        Assert.assertEquals(1000, savingsAccount.getMinBalance());
    }

    @Test
    public void testWithdrawalLimit() {
        UserInformation user = new UserInformation("Killer", "Miller", "Killer.miller@example.com", "2222222222", "222222222", "South Africa", "Teacher", "Male", new Date(1975, 8, 5));
        SavingsAccount savingsAccount = new SavingsAccount(user);

        // Limiting the Withdrawal Limit using setWithdrawal Method
        savingsAccount.setWithdrawalLimit(100, 500);

        // Checks for Boundary Value Asesertions
        Assert.assertEquals(100, savingsAccount.getMinWithdrawal());
        Assert.assertEquals(500, savingsAccount.getMaxWithdrawal());
    }

    @Test
    public void testGetAccountType() {
        UserInformation user = new UserInformation("J", "D", "j.d@example.com", "9090909090", "124456789", "Hyderabad", "Engineer", "Male", new Date(2001, 1, 1));
        SavingsAccount savingsAccount = new SavingsAccount(user);

        // Check if the correct account type is returned
        Assert.assertEquals(Account.SAVINGS_ACCOUNT, savingsAccount.getAccountType());
    }
}



