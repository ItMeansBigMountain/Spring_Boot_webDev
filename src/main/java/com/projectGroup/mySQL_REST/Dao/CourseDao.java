package com.projectGroup.mySQL_REST.Dao;
import com.projectGroup.mySQL_REST.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {
}
