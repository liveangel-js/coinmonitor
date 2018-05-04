package org.liveangel.A;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail(String receiver, String title, String content) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("448576871@qq.com");
        message.setTo(receiver);
        message.setSubject(title);
        message.setText(content);

        mailSender.send(message);
    }

}
