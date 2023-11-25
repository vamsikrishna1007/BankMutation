package org.example;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class AccountTest {

    // Create a user for testing
    // lets create current account or savings account for testing purposes
    @Test
    public void testPayment() {
        // Create a test instance
        System.out.println("Running testPayment...");
        UserInformation user = new UserInformation("Vamsikrishna", "s", "Leelavamsikrishna.s@example.com", "123457840", "123456789", "Bangalore", "Engineer", "Male", new Date(2000, 1, 1));
        Account account = new SavingsAccount(user);
        account.setBalance(1000);
        account.setMinBalance(500);

        assertTrue(account.payBill(300));
        assertEquals(700, account.getBalance(), 0.01);


        assertFalse(account.payBill(800));
        assertEquals(700, account.getBalance(), 0.01);
    }

    @Test
    public void testDepositMoney() {
        // Create a test instance
        UserInformation user = new UserInformation("ravi", "kishan", "ravi.kishan@example.com", "9876544910", "987654321", "Usa", "Doctor", "Female", new Date(1995, 5, 15));
        Account account = new CurrentAccount(user);
        account.setBalance(500);

        // Test depositing money
        account.depositMoney(200);
        assertEquals(700, account.getBalance(), 0.01);
    }

    @Test
    public void testTransferMoney() {
        // Create two test instances
        UserInformation user1 = new UserInformation("Albama", "Obama", "albama.obama@example.com", "1111111111", "111111111", "Wall street", "Artist", "Female", new Date(1980, 10, 20));
        UserInformation user2 = new UserInformation("Bob", "Miller", "bob.miller@example.com", "2222222222", "222222222", "Dalal Street", "Teacher", "Male", new Date(1975, 8, 5));
        Account account1 = new SavingsAccount(user1);
        Account account2 = new CurrentAccount(user2);
        account1.setBalance(1000);
        account2.setBalance(500);

        // Testing transferring money
        assertTrue(account1.transferMoney(account2, 300));
        assertEquals(700, account1.getBalance(), 0.01);
        assertEquals(800, account2.getBalance(), 0.01);

        // Testing insufficient balance
        assertFalse(account1.transferMoney(account2, 800));
        assertEquals(700, account1.getBalance(), 0.01);
        assertEquals(800, account2.getBalance(), 0.01);
    }



    @Test
    public void testBelowMinWithdrawal() {

        UserInformation user = new UserInformation("Alice", "Johnson", "alice.j@example.com", "1234567890", "987654321", "456 Oak St", "Teacher", "Female", new Date(1985, 5, 10));
        Account account = new CurrentAccount(user);
        // Set the initial balance
        account.setBalance(1200.0);
        int result = account.withdrawMoney(50.0);
        assertEquals(Account.WITHDRAWAL_LIMIT_UNDER, result);
        assertEquals(1200.0, account.getBalance(), 0.01);
    }



    @Test
    public void testBelowMinimumWithdrawal() {
        UserInformation user = new UserInformation("Alice", "Johnson", "alice.j@example.com", "1234567890", "987654321", "456 Oak St", "Teacher", "Female", new Date(1985, 5, 10));
        Account account = new CurrentAccount(user);

        account.setBalance(1200.0);

        int result = account.withdrawMoney(50.0);
        assertEquals(Account.WITHDRAWAL_LIMIT_UNDER, result);
        assertEquals(1200.0, account.getBalance(), 0.01);
    }

    @Test
    public void testMoneyEqualMinWithdrawal1(){
        UserInformation user = new UserInformation("Ali", "John", "ice.j@mple.com", "1256467890", "9876543000", "456 St", "father", "male", new Date(1955, 5, 10));
        Account account = new CurrentAccount(user);
        account.setBalance(1000.0);
        int result = account.withdrawMoney(99.0);
        assertEquals(Account.WITHDRAWAL_LIMIT_UNDER, result);
        assertEquals(1000, account.getBalance(), 0.01);
    }

    @Test
    public void testWithMoneyEqualMinWithdrawal2(){
        UserInformation user = new UserInformation("li", "ohn", "ce.j@mple.com", "256467890", "876543000", "456 St", "father", "male", new Date(1955, 5, 10));
        Account account = new CurrentAccount(user);

        account.setBalance(1000.0);

        int result = account.withdrawMoney(100.0);

        assertEquals(Account.WITHDRAWAL_LIMIT_EQUAL, result);
        assertEquals(1000, account.getBalance(), 0.01);
    }

    @Test
    public void testWithMoneyEqualMaxWithdrawal(){
        UserInformation user = new UserInformation("A", "n", "ie.j@ple.com", "1256067890", "6876543000", "456 You St", "Liver", "male", new Date(1955, 4, 10));
        Account account = new CurrentAccount(user);

        account.setBalance(55000.0);

        int result = account.withdrawMoney(50001.0);

        assertEquals(Account.WITHDRAWAL_LIMIT_OVER, result);
        assertEquals(55000, account.getBalance(), 0.01);
    }

    @Test
    public void testWithMoneyEqualMinBalance(){
        UserInformation user = new UserInformation("Abc", "nui", "ife.j@ple.com", "3256067890", "8876543000", "456 Yoyyu St", "Liiiver", "male", new Date(1955, 4, 10));
        Account account = new CurrentAccount(user);

        account.setBalance(1000.0);

        int result = account.withdrawMoney(991.0);

        assertEquals(Account.INSUFFICIENT_BALANCE, result);
        assertEquals(1000, account.getBalance(), 0.01);
    }


    @Test
    public void testWithMoneyExceedingBalance() {
        UserInformation user = new UserInformation("Alice", "Johnson", "alice.j@example.com", "1234567890", "987654321", "456 Oak St", "Teacher", "Female", new Date(1985, 5, 10));
        Account account = new CurrentAccount(user);

        account.setBalance(1200.0);

        int result = account.withdrawMoney(1500.0);

        assertEquals(Account.INSUFFICIENT_BALANCE, result);
        assertEquals(1200.0, account.getBalance(), 0.01);
    }

    @Test
    public void testSuccessfulWithdrawal() {
        UserInformation user = new UserInformation("Alice", "Johnson", "alice.j@example.com", "1234567890", "987654321", "456 Oak St", "Teacher", "Female", new Date(1985, 5, 10));
        Account account = new CurrentAccount(user);

        account.setBalance(1200.0);

        int result = account.withdrawMoney(500.0);

        assertEquals(0, result);
        assertEquals(700.0, account.getBalance(), 0.01);
    }


    @Test
    public void testGenerateUniqueAccountNumber() {
        Database db = Database.getInstance();

        Account account = new CurrentAccount(new UserInformation("Test", "User", "test@example.com", "1234567890", "987654321", "123 Main St", "Engineer", "Male", new Date(1995, 5, 15)));
        String accountNum = account.generateUniqueAccountNumber();
        assertNotNull(accountNum);
        assertFalse(accountNum.isEmpty());
        assertTrue(db.isAccountNumberUnique(accountNum));
    }

    @Test
    public void testGenerateUniqueAccountNumberWithExistingAccounts() {
        Database db = Database.getInstance();

        Account existingAccount = new SavingsAccount(new UserInformation("Existing", "User", "existing@example.com", "1234567890", "987654321", "123 Main St", "Engineer", "Male", new Date(1990, 1, 1)));
        existingAccount.setAccountNo("12345678");
        // Assuming this account number already exists
        db.addNewAccount(existingAccount);

        String accountNum = existingAccount.generateUniqueAccountNumber();
        assertNotNull(accountNum);
        assertFalse(accountNum.isEmpty());
        assertTrue(db.isAccountNumberUnique(accountNum));
    }

    @Test
    public void testWithdrawMoneyWithInvalidAmount() {
        UserInformation user = new UserInformation("Test", "User", "test@example.com", "1234567890", "987654321", "123 Main St", "Engineer", "Male", new Date(1995, 5, 15));
        Account account = new CurrentAccount(user);
        account.setBalance(1000.0);
        int result = account.withdrawMoney(0.0);
        // Assuming minWithdrawal is greater than 0.0
        assertEquals(Account.WITHDRAWAL_LIMIT_UNDER, result);
        assertEquals(1000.0, account.getBalance(), 0.01);
    }

}


