package com.projectGroup.mySQL_REST.Controller;

import com.projectGroup.mySQL_REST.Entity.Admin;
import com.projectGroup.mySQL_REST.Entity.Course;
import com.projectGroup.mySQL_REST.Service.CourseService;
import com.projectGroup.mySQL_REST.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Route_Controller {

    @Autowired
    private CourseService courseService;
    @Autowired
    private MailService mailService;

    //HOME SCREEN
    @RequestMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + "! Go to localhost:8080/courses to check me out!";
    }

    @GetMapping("/courses") // GET ALL
    public List<Course> displayCourses() {
        return this.courseService.getAllCourses();
    }

    @PostMapping("/courses") // ADD
    public Course _addCourse(@RequestBody Course c) {
        this.mailService.send_mail_toAdmins("CREATED COURSE", c.getTitle() + "\n" + c.getInstructor() + "\n" + c.getCourseid());
        return this.courseService.addCourse(c);
    }

    @PutMapping("/courses") // PUT
    public List<Course> _updateCourseByID(@RequestBody Course c) {
        this.mailService.send_mail_toAdmins("UPDATED COURSE", c.getTitle() + "\n" + c.getInstructor() + "\n" + c.getCourseid());
        return this.courseService.updateCourse(c);
    }

    @DeleteMapping("/courses/{id}") // DELETE
    public List<Course> _deleteCourseByID(@PathVariable int id) {
        this.mailService.send_mail_toAdmins("DELETED COURSE", String.valueOf(id));
        return this.courseService.deleteCourse(id);
    }

    @GetMapping("/courses/{id}") // GET ID
    public Course _displayCourseByID(@PathVariable String id) {
        return this.courseService.getCourseById(Integer.parseInt(id));
    }


    @RequestMapping("/sendmail")
    public String _sendMail(@RequestParam(value = "to") String to_email, @RequestParam(value = "subject") String subject, @RequestParam(value = "body", defaultValue = "null") String body) {
        return "Success: " + this.mailService.send_mail(to_email, subject, body);
    }


    // ADD ADMIN
    @PostMapping("/admin")
    public Admin _handle_Admin(@RequestBody Admin a) {
        //  System.out.println(pass_key);
        return this.mailService.addAdmin(a);
    }

}

