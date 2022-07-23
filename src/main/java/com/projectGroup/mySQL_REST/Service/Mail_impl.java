package com.projectGroup.mySQL_REST.Service;

import com.projectGroup.mySQL_REST.Dao.AdminDao;
import com.projectGroup.mySQL_REST.Entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class Mail_impl implements MailService {


    @Autowired
    private AdminDao adminDao;

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String cfg_email;


    @Override
    public List<Admin> send_mail_toAdmins(String subject, String body) {
        List<Admin> admins = this.adminDao.findAll();
        List<Admin> error_log = new ArrayList<>();
        for (int i = 0; i < admins.size(); i++) {
            try {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom(this.cfg_email);
                message.setTo(admins.get(i).getEmail());
                message.setSubject(subject);
                message.setText(body);
                this.javaMailSender.send(message);
            } catch (Exception e) {
                System.out.println("LOG: " + admins.get(i).getEmail() + " == ERROR");
                error_log.add(admins.get(i));
            }
        }
        return error_log;
    }


    @Override
    public Boolean send_mail(String to_email, String subject, String body) {
        List<Admin> admins = this.adminDao.findAll();
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(this.cfg_email);
            message.setTo(to_email);
            message.setSubject(subject);
            message.setText(body);
            System.out.println(message);
            this.javaMailSender.send(message);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }


    @Override
    public Admin addAdmin(Admin a) {
        return this.adminDao.save(a);
    }


}

