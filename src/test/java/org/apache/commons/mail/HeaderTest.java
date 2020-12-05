package org.apache.commons.mail;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import junit.framework.TestCase;

public class setFrom extends TestCase{
    Email testEmail;

    public void setup(){
        testEmail = new SimpleEmail();
    }
	@Test 
	public void testSetFrom() throws EmailException {
		String email = "a@b.com";
        testEmail.setFrom(email);
        System.out.println("This is a message from set From test class");
        System.out.println("This test class tests whether the Email.getFromAddress() function is working properly");
        System.out.println("This test is written by adl___");
		assertEquals(email, testEmail.getFromAddress().toString());
	}
}