package com.projectGroup.mySQL_REST.Entity;


import javax.persistence.*;

@Entity
@Table(name = "tbl_adminUsers")
public class Admin {
    @Id
    @Column(name = "pk")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String email;


    public Admin()
    {

    }

    public Admin(int id, String email) {
        this.id = id;
        this.email = email;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
