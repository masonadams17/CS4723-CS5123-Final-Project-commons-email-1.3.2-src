package org.apache.commons.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import java.util.Date;
import java.util.Calendar;
import junit.framework.TestCase;

public class SentDateTest extends TestCase{

    Email testEmail;
	public void setUp() {
		testEmail = new SimpleEmail();
	}
    @Test
    public void testGetSentDate()
    {
		Date dtTest = Calendar.getInstance().getTime();
		//with null input 
		testEmail.setSentDate(null);
        Date sentDate = testEmail.getSentDate();
        
        System.out.println("This is a message from the SentDateTest Test Class");
        System.out.println("This class test the funcionality of the setSentDate() and getSentDate() function in the Email.java class");
        System.out.println("This test was written by Mason - adl___");

        assertTrue(Math.abs(sentDate.getTime() - dtTest.getTime()) < 1000);
        // with input date
        


        testEmail.setSentDate(dtTest);
        assertEquals(dtTest, testEmail.getSentDate());
        
       
    }
}