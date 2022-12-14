package com.example.domain;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class MemberModel {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String email;

    @Column(name = "degree")
    private String degree;

    @Column(name = "name")
    private String name;

    @Column(name = "graduation")
    private int graduation;

    public MemberModel() {

    }

    public MemberModel(String degree, String name, int graduation) {
        this.degree = degree;
        this.name = name;
        this.graduation = graduation;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGraduation() {
        return graduation;
    }

    public void setGraduation(int graduation) {
        this.graduation = graduation;
    }


}


