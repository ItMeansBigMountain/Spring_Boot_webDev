package com.projectGroup.mySQL_REST.Dao;
import com.projectGroup.mySQL_REST.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
}
