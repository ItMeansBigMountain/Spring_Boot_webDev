package com.projectGroup.mySQL_REST.Service;

import com.projectGroup.mySQL_REST.Dao.CourseDao;
import com.projectGroup.mySQL_REST.Entity.Course;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Course_impl implements CourseService {


    @Autowired
    private JavaMailSender javaMailSender;


    @Autowired
    private CourseDao courseDao;

    @Override // GET --> /courses
    public List<Course> getAllCourses() {
        return this.courseDao.findAll();
    }


    @Override // GET --> /courses/{id}
    public Course getCourseById(int requested_Course_ID) {
        Optional<Course> c = this.courseDao.findById(requested_Course_ID);
        if (c.isEmpty()) {
            return null;
        }
        return c.get();
    }

    @Override  // POST --> /courses
    public Course addCourse(Course c) {
        return this.courseDao.save(c);
    }

    @Override // PUT --> /courses
    public List<Course> updateCourse(Course c) {
        Optional<Course> q = this.courseDao.findById(c.getCourseid());
        if (q.isPresent()) {
            ;
            this.courseDao.save(c);
            return this.courseDao.findAll();
        }
        return null;
    }

    @Override  // DELETE --> /courses/{id}
    public List<Course> deleteCourse(int id) {
        this.courseDao.deleteById(id);
        return this.courseDao.findAll();
    }

    @Override
    public Boolean send_mail(String to_email, String subject, String body) {

        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("sosai1010@outlook.com");
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

}


