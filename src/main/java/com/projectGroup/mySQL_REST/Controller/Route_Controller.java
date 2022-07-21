package com.projectGroup.mySQL_REST.Controller;

import com.projectGroup.mySQL_REST.Entity.Course;
import com.projectGroup.mySQL_REST.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Route_Controller {

    @Autowired
    private CourseService courseService;


    //default param value example
    @RequestMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello " + name + "! Go to localhost:8080/courses to check me out!";
    }


    @GetMapping("/courses") // GET ALL
    public List<Course> displayCourses() {
        return this.courseService.getAllCourses();
    }

    @PostMapping("/courses") // ADD
    public Course addCourse(@RequestBody Course c) {
        return this.courseService.addCourse(c);
    }


    @PutMapping("/courses") // UPDATE
    public List<Course> updateCourseByID(@RequestBody Course c) {
        return this.courseService.updateCourse(c);
    }


    @DeleteMapping("/courses/{id}") // DELETE
    public List<Course> deleteCourseByID(@PathVariable int id) {
        return this.courseService.deleteCourse(id);
    }


    @GetMapping("/courses/{id}") // GET ID
    public Course displayCourseByID(@PathVariable String id) {
        return this.courseService.getCourseById(Integer.parseInt(id));
    }


    // YOU NEED DEFAULT VALUES  !!DEBUG!!
    @RequestMapping("/test")
    public List test(@RequestParam(value = "name", defaultValue = "World") String name, @RequestParam(value = "age", defaultValue = "50") int age, @RequestParam(value = "message", defaultValue = "message") String message) {
        return (List.of(name, age, message));
    }

}
