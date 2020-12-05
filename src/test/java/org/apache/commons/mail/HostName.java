package org.apache.commons.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailConstants;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import java.util.Properties;
import javax.mail.Session;
import org.junit.Test;

import junit.framework.TestCase;

public class HostName extends TestCase{
    /** Mail server used for testing */
	protected String strTestMailServer = "localhost";
	
	/** default port */
    private static int mailServerPort = 2500;
    
    /** Test characters acceptable to email*/
    protected String[] testCharsValid =
        {
                " ",
                "a",
                "A",
                "\uc5ec",
                "0123456789",
                "012345678901234567890",
                "\n"
        };

    Email testEmail;
    public void setUp() {
        testEmail = new SimpleEmail();
    }


    @Test
    public void testGetHostName() throws EmailException
    {
        Properties props = new Properties(System.getProperties());

		props.setProperty(EmailConstants.MAIL_TRANSPORT_PROTOCOL, EmailConstants.SMTP);
		props.setProperty(EmailConstants.MAIL_PORT, String.valueOf(mailServerPort));
		props.setProperty(EmailConstants.MAIL_HOST, strTestMailServer);
		props.setProperty(EmailConstants.MAIL_DEBUG, String.valueOf(false));
        
        System.out.println("This is a message from the HostName Test Class");
        System.out.println("This class test the funcionality of the getHostName() function in the Email.java class");
        System.out.println("This test was written by Mason - adl___");

		/** tests exception where the hostname is not already specified and there is no session*/
		assertEquals(null, testEmail.getHostName());
		
        for (int i = 0; i < testCharsValid.length; i++)
        {
            testEmail.setHostName(testCharsValid[i]);
            assertEquals(testCharsValid[i], testEmail.getHostName());
        }
        
        
        Session session = Session.getInstance(props,null);
        


		testEmail.setMailSession(session);
        assertEquals(session.getProperty(EmailConstants.MAIL_HOST), testEmail.getHostName());
    }
}