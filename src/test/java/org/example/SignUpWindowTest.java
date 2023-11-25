//package org.example;
//import static org.junit.Assert.*;
//import org.junit.*;
//
//public class SignUpWindowTest {
//
//    SignUpWindow signUpWindow;
//
//    @Before
//    public void setUp() {
//        signUpWindow = new SignUpWindow();
//    }
//
//    @Test
//    public void testIsFormFilled() {
//        // test for form filled
//        signUpWindow.firstNameT.setText("Vamsi");
//        signUpWindow.lastNameT.setText("S");
//        signUpWindow.email.setText("vamsikrishna.S@example.com");
//        signUpWindow.phoneNo.setText("9398324355");
//        signUpWindow.NID.setText("123456789");
//        signUpWindow.address.setText("Hyderabad");
//        signUpWindow.occupation.setText("Engineer");
//        signUpWindow.maleB.setSelected(true);
//
//        assertTrue(signUpWindow.isFormFilled());
//
//        // Form not filled or left empty
//        signUpWindow.firstNameT.setText("");
////       When only one field is filled
//        signUpWindow.lastNameT.setText("S");
//
//        assertFalse(signUpWindow.isFormFilled());
//    }
//
//    @Test
//    public void testGenerateDate() {
//        signUpWindow.generateDate();
//
//        assertNotNull(signUpWindow.day.getItemAt(0));
//        assertNotNull(signUpWindow.month.getItemAt(0));
//        assertNotNull(signUpWindow.year.getItemAt(0));
//    }
//
//
//    @After
//    public void tearDown() {
//        signUpWindow.dispose();
//    }
//}
