package com.projectGroup.mySQL_REST.Service;
import com.projectGroup.mySQL_REST.Entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(int requested_Course_ID);
    Course addCourse(Course c);
    List<Course> updateCourse(Course c);
    List<Course> deleteCourse(int id);
    Boolean send_mail(String to_email , String subject , String body);
}



