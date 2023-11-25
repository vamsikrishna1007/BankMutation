package org.example;


import java.io.*;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.io.File;

public class DatabaseTest {

    private Database db;
    private PrintStream originalOut;
    private ByteArrayOutputStream outputStream;
    @Before
    public void setUp() {
        db = Database.getInstance();

        UserInformation user1 = new UserInformation("SLVK", "BS", "Slvk.BS@example.com", "1234567890", "123456789", "Bangkok", "Engineer", "Male", new Date(2019, 5, 15));
        Account account1 = new CurrentAccount(user1);
        account1.setAccountNo("93064072");
        account1.setPIN("9597");
        db.addNewAccount(account1);
        originalOut = System.out;

    }

    @After
    public void tearDown() {

        File file = new File("AccountList.txt");
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void testGetInstance() {

        assertNotNull(Database.getInstance());
    }

    @Test
    public void instanceEqualsNull1() {
        Database db1 = Database.getInstance();
        Account retrievedAccount = db1.getAccount("93064072");
        assertNotNull(retrievedAccount);
    }

    @Test
    public void instanceEqualsNull2() {
        Database db2 = Database.getInstance();
        Account retrievedAccount2 = db2.getAccount("90000000","2300");
        assertNull(retrievedAccount2);
    }

    @Test
    public void instanceEqualsNull3() {
        Database db3 = Database.getInstance();
        Account retrievedAccount3 = db3.getAccount("40000000");
        assertNull(retrievedAccount3);
    }

    @Test
    public void testGetAccountByAccountNo() {

        Account retrievedAccount = db.getAccount("93064072");
        assertNotNull(retrievedAccount);
        assertEquals("9597", retrievedAccount.getPIN());
    }

    @Test
    public void testGetAccountByAccountNo_PIN() {
        // Test getting an account by account number and PIN
        Account retrievedAccount = db.getAccount("93064072", "9597");
        assertNotNull(retrievedAccount);
    }

    @Test
    public void testAddNewAccount() {
        // Test adding a new account
        UserInformation user = new UserInformation("Alice", "Smith", "alice.smith@example.com", "9876543210", "987654321", "456 Oak St", "Doctor", "Female", new Date(1990, 3, 20));
        Account newAccount = new SavingsAccount(user);
        newAccount.setAccountNo("12345678");
        newAccount.setPIN("5678");

        db.addNewAccount(newAccount);

        // Check if the account was added successfully
        assertNotNull(db.getAccount("12345678", "5678"));
    }

    @Test
    public void testIsUnique() {
        // Test checking if an account number is unique
        assertTrue(db.isAccountNumberUnique("12345679"));
        assertFalse(db.isAccountNumberUnique("93064072"));
    }



    @Test
    public void testLoadData() {
        // Test loading data from a file
        db.saveData();  // Save some data first
        db.loadData();
        // Checking if they are loaded successfully
        assertNotNull(db.getAccount("93064072", "9597"));
    }



    @Test
    public void testSaveData() {


        // Adding a testing account
        UserInformation user = new UserInformation("Balaji", "Smith", "Balaji.smith@example.com", "9876543210", "987654321", "Bangalore", "Doctor", "Female", new Date(1990, 3, 20));
        Account newAccount = new SavingsAccount(user);
        newAccount.setAccountNo("12345678");
        newAccount.setPIN("5678");
        db.addNewAccount(newAccount);
        db.saveData();

        // Check if the file exists
        File file = new File("AccountList.txt");
        assertTrue(file.exists());

        // Check if the content of the file is as expected
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            assertTrue(content.toString().contains("12345678"));
            assertTrue(content.toString().contains("5678"));
        } catch (IOException e) {
            fail("IOException occurred while reading the file");
        }
    }

    @Test
    public void testPrintAccounts() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Add test accounts
        UserInformation user1 = new UserInformation("Rahul", "Puram", "Rahul.dpuram@example.com", "1234547890", "1234676789", "Hyderabad", "Engineer", "Male", new Date(1995, 5, 15));
        Account account1 = new CurrentAccount(user1);
        account1.setAccountNo("93064072");
        account1.setPIN("9597");
        db.addNewAccount(account1);

        UserInformation user2 = new UserInformation("Vamsi", "Krishna", "abc", "1234567890", "1256789", "Nagaland", "ENT", "Male", new Date(1995, 5, 15));
        Account account2 = new CurrentAccount(user2);
        account2.setAccountNo("90663914");
        account2.setPIN("9995");
        db.addNewAccount(account2);
        db.printAccounts();

        // Restore System.out
        System.setOut(originalOut);

        // Verify the printed output
        String printedOutput = outContent.toString();
        assertTrue(printedOutput.contains("93064072 9597"));
        assertTrue(printedOutput.contains("90663914 9995"));
    }




}

