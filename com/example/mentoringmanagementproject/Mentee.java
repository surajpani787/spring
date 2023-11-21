package com.example.mentoringmanagementproject;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class Mentee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "studentName", nullable = false)
    private String studentName;
    @Column(name = "studentRegdNo")
    private String studentRegdNo;
    @Column(name = "studentPhone")
    private String studentPhone;
    @Column(name = "studentEmail")
    private String studentEmail;
    @Column(name = "parentName")
    private String ParentName;
    @Column(name = "parentNo")
    private String parentNo;
    @Column(name = "password")
    private String password;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentRegdNo() {
        return studentRegdNo;
    }

    public void setStudentRegdNo(String studentRegdNo) {
        this.studentRegdNo = studentRegdNo;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getParentName() {
        return ParentName;
    }

    public void setParentName(String parentName) {
        ParentName = parentName;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

