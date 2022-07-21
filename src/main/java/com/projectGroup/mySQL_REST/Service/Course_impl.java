package com.projectGroup.mySQL_REST.Service;

import com.projectGroup.mySQL_REST.Dao.CourseDao;
import com.projectGroup.mySQL_REST.Entity.Course;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Course_impl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        return this.courseDao.findAll();
    }

    @Override
    public Course getCourseById(int requested_Course_ID) {
        Optional<Course> c = this.courseDao.findById(requested_Course_ID);
        if (c.isEmpty()) {
            throw new RuntimeException(("Course not found for id: " + requested_Course_ID));
        }
        return c.get();
    }


    @Override
    public Course addCourse(Course c) {
        return this.courseDao.save(c);
    }

    @Override
    public List<Course> updateCourse(Course c) {
        this.courseDao.save(c);
        return this.courseDao.findAll();
    }

    @Override
    public List<Course> deleteCourse(int id) {
        this.courseDao.deleteById(id);
        return this.courseDao.findAll();
    }



}
