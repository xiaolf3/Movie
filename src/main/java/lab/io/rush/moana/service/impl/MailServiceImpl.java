package lab.io.rush.moana.service.impl;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import lab.io.rush.moana.entity.Email;
import lab.io.rush.moana.service.MailService;
@Service("mailService")
public class MailServiceImpl implements MailService {  
	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
    private TaskExecutor taskExecutor;
  
    private Log log = LogFactory.getLog(getClass());  
    private StringBuffer message = new StringBuffer();  
  
    @Override  
    public void sendMail(Email email) throws MessagingException, IOException{  
        /*if (email.getAddress().length > 5) {// 收件人大于5封时，采用异步发送 
            sendMailByAsynchronousMode(email); 
            this.message.append("收件人过多，正在采用异步方式发送...<br/>"); 
        } else {*/  
        sendMailBySynchronizationMode(email);  
        //this.message.append("正在同步方式发送邮件...<br/>");  
        //}  
    }  
  
      
    @Override  
    public void sendMailByAsynchronousMode(final Email email) {  
        taskExecutor.execute(new Runnable() {  
            public void run() {  
                try {  
                    sendMailBySynchronizationMode(email);  
                } catch (Exception e) {  
                    log.info(e);  
                }  
            }  
        });  
    }  
  
    @Override  
    public void sendMailBySynchronizationMode(Email email)  
            throws MessagingException, IOException {  
        MimeMessage mime = mailSender.createMimeMessage();  
        MimeMessageHelper helper = new MimeMessageHelper(mime, true, "utf-8");  
        helper.setFrom(email.getFromAddress());// 发件人  
        helper.setTo(email.getToAddress());// 收件人  
        helper.setReplyTo(email.getFromAddress());// 回复到  
        helper.setSubject(email.getSubject());// 邮件主题  
        helper.setText(email.getContent(), true);// true表示设定html格式  
        mailSender.send(mime);  
    }  
  
      
      
      
    public JavaMailSender getMailSender() {  
        return mailSender;  
    }  
  
    public void setMailSender(JavaMailSender mailSender) {  
        this.mailSender = mailSender;  
    }  
  
    public TaskExecutor getTaskExecutor() {  
        return taskExecutor;  
    }  
  
    public void setTaskExecutor(TaskExecutor taskExecutor) {  
        this.taskExecutor = taskExecutor;  
    }  
  
    public Log getLog() {  
        return log;  
    }  
  
    public void setLog(Log log) {  
        this.log = log;  
    }  
  
    public StringBuffer getMessage() {  
        return message;  
    }  
  
    public void setMessage(StringBuffer message) {  
        this.message = message;  
    }  
  
} 