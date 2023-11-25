package org.example;


import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class UserInformationTest {

    @Test
    public void testToString() {
        Date birthdate = new Date();
        UserInformation user = new UserInformation("Vamsi", "Krishna", "vamsi.krishna@example.com",
                "124567893", "987654321", "Hyderabad", "student", "Male", birthdate);

        String expectedToString = "Vamsi\nKrishna\nvamsi.krishna@example.com\n124567893\n987654321\nHyderabad\nstudent\nMale\n"
                + new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").format(birthdate);


        // Asserting if actual string represents the expected string
        assertEquals(expectedToString, user.toString());
    }
}
