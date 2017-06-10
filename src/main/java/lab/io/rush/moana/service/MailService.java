package lab.io.rush.moana.service;



import java.io.IOException;

import javax.mail.MessagingException;

import lab.io.rush.moana.entity.Email;

public interface MailService {
	public void sendMail(Email email) throws MessagingException, IOException;
	public void sendMailByAsynchronousMode(final Email email);
	public void sendMailBySynchronizationMode(Email email) throws MessagingException, IOException;
}
