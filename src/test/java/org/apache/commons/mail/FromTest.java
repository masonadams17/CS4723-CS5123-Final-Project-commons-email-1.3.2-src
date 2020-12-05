package org.apache.commons.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Test;
import junit.framework.TestCase;

public class FromTest extends TestCase{
    Email testEmail;

    public void setup(){
        testEmail = new SimpleEmail();
    }
	public void testSetFrom() throws EmailException {
        testEmail.setFrom("a@b.com");
        System.out.println("This is a message from set From test class");
        System.out.println("This test class tests whether the Email.getFromAddress() function is working properly");
        System.out.println("This test is written by adl___");
		assertEquals("a@b.com", testEmail.getFromAddress().toString());
	}
}