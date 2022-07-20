package com.genSpark.Spring_Boot_Template.Service;
import com.genSpark.Spring_Boot_Template.Entity.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    List<Course> getCourseById(int requested_Course_ID);
    Course addCourse(Course c);
    Course updateCourse(Course c);
    List<Course> deleteCourse(int id);
}
