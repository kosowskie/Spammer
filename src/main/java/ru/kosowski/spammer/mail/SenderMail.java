package ru.kosowski.spammer.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

@Service
public class SenderMail {

    private JavaMailSender javaMailSender;
    private MailService mailService;
    
    @Value("${spring.mail.receiver}")
    private String mail;

    @Autowired
    public SenderMail(JavaMailSender javaMailSender, MailService mailService) {
        this.javaMailSender = javaMailSender;
        this.mailService = mailService;
    }

    @Schedules({
            @Scheduled(cron = "${spring.mail.cron}"),
            @Scheduled(fixedDelay = 10000)
    })
     public void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail);

        msg.setSubject(mailService.getTitle());
        msg.setText(mailService.getContent());

        javaMailSender.send(msg);
    }
}