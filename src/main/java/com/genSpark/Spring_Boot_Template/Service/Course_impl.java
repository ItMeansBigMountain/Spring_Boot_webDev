package com.genSpark.Spring_Boot_Template.Service;

import com.genSpark.Spring_Boot_Template.Entity.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Course_impl implements CourseService {

    List<Course> list;

    public Course_impl() {
        list = new ArrayList<>();
        list.add(new Course(1, "java into", "Jacob"));
        list.add(new Course(2, "java springBoot", "Pradeep"));
    }


    @Override
    public List<Course> getAllCourses() {
        return list;
    }

    @Override
    public List<Course> getCourseById(int requested_Course_ID) {
        return list.stream().filter(i -> i.getCourseid() == requested_Course_ID).collect(Collectors.toList());
    }

    @Override
    public Course addCourse(Course c) {
        // Course c = new Course( list.get(list.size()-1).getCourseid()+1 , title, instructor );
        list.add(c);
        return c;
    }

}
