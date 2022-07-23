package com.projectGroup.mySQL_REST.Service;

import com.projectGroup.mySQL_REST.Entity.Admin;

import java.util.List;

public interface MailService {
    Boolean send_mail(String to_email, String subject, String body);
    List<Admin> send_mail_toAdmins( String subject, String body);
    Admin addAdmin(Admin a);
}
