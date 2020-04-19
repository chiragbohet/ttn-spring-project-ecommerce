package com.chiragbohet.ecommerce.Utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailSenderService")
public class EmailSenderService {

    private JavaMailSender javaMailSender;

    public static final String senderEmail = "chiragtest9654@gmail.com";

    @Autowired
    public EmailSenderService(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }

    @Async
    public  void sendEmail(SimpleMailMessage email)
    {
        javaMailSender.send(email);
    }


    public SimpleMailMessage getCustomerAwaitingActivationMail(String customerEmail, String confirmationToken)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(customerEmail);
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom(senderEmail);
        mailMessage.setText("To confirm your account, please click here : "
                +"http://localhost:8080/register/confirm?token="+confirmationToken);

        return mailMessage;
    }

    public SimpleMailMessage getCustomerRegistrationCompletedMail(String customerEmail)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(customerEmail);
        mailMessage.setSubject("Registration Completed!");
        mailMessage.setFrom(senderEmail);
        mailMessage.setText("Congratulations! Your account is now verified.");

        return mailMessage;
    }

    public SimpleMailMessage getCustomerDeactivationMail(String customerEmail)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(customerEmail);
        mailMessage.setSubject("Account deactivated!");
        mailMessage.setFrom(senderEmail);
        mailMessage.setText("Dear Customer, your account has been deactivated.\nPlease contact customer care for more details.");
        return mailMessage;
    }

    public SimpleMailMessage getSellerActivationMail(String sellerEmail)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(sellerEmail);
        mailMessage.setSubject("Registration Completed!");
        mailMessage.setFrom(senderEmail);
        mailMessage.setText("Congratulations! Your account is now verified.");

        return mailMessage;
    }

    public SimpleMailMessage getSellerDeactivationMail(String sellerEmail)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(sellerEmail);
        mailMessage.setSubject("Account deactivated!");
        mailMessage.setFrom(senderEmail);
        mailMessage.setText("Dear Customer, your account has been deactivated.\nPlease contact customer care for more details.");
        return mailMessage;
    }

    public SimpleMailMessage getPasswordUpdatedMail(String email)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Password Updated!");
        mailMessage.setFrom(senderEmail);
        mailMessage.setText("Dear User, your password was recently changed.\nIf this was not done by you, contact customer care immediately.");
        return mailMessage;
    }

    public SimpleMailMessage getSellerAwaitingActivationMail(String email)
    {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Registration completed");
        mailMessage.setFrom(senderEmail);
        mailMessage.setText("Dear seller your account has been created and is waiting for an approval.");
        return mailMessage;
    }


}
