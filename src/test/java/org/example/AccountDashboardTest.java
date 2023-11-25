//package org.example;
//import static org.junit.Assert.*;
//import org.junit.Before;
//import org.junit.Test;
//import java.util.Date;
//
//
//import static org.junit.Assert.assertEquals;
//
//public class AccountDashboardTest {
//
//    private Database db;
//
//    @Before
//    public void setUp() {
//        db = Database.getInstance();
//
//        UserInformation user1 = new UserInformation("Balaji", "Sankalp", "Balaji.Sankalp@iiitb.ac.in", "128943256", "123465789", "Pune", "Engineer", "Male", new Date(2009, 5, 15));
//        Account account1 = new CurrentAccount(user1);
//        account1.setAccountNo("93064072");
//        account1.setPIN("9597");
//        db.addNewAccount(account1);
//
//        UserInformation user2 = new UserInformation("Vamsi", "Krishna", "abc", "1234567890", "1256789", "Hyderabad", "Engineer", "Male", new Date(2002, 5, 15));
//        Account account2 = new CurrentAccount(user2);
//        account2.setAccountNo("90663914");
//        account2.setPIN("9995");
//        db.addNewAccount(account2);
//    }
//
//    @Test
//    public void testTransferWithSufficientBalance() {
//
//
////        check authentication and login
//        Account authenticatedAccount = authenticate("93064072", "9597");
//
//        // account dashboardboard of the log account
//        AccountDashboard dashboard = new AccountDashboard(authenticatedAccount);
//
//
//        dashboard.accountNoT.setText("90663914");
//        dashboard.amountT.setText("600.0");
//
//        // call the transfer operation check if it is transfering
//        dashboard.transfer();
//
//
//        assertEquals(400,authenticatedAccount.getBalance(), 0.001); // Expected balance: 500.0 - 200.0 = 300.0
//    }
//
////
////    @Test
////    public void testTransferWithInsufficientBalance() {
////
////        Account authenticatedAccount = authenticate("90663914", "9995");
////        AccountDashboard dashboard = new AccountDashboard(authenticatedAccount);
////
////        dashboard.accountNoT.setText("93064072");
////        dashboard.amountT.setText("200.0");
////
////        // call transfer operation
////        dashboard.transfer();
////
////
////        assertEquals(1200,authenticatedAccount.getBalance(), 0.001);
////
////
////    }
//
//
//    private Account authenticate(String accountNo, String pin) {
//
//        return db.getAccount(accountNo, pin);
//    }
//}


