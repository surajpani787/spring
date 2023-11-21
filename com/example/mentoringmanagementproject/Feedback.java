package com.example.mentoringmanagementproject;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="subject",nullable = false)
    private String subject;
    @Column(name="classesHeld")
    private String classesHeld;
    @Column(name="classesAttented")
    private String classesAttented;
    @Column(name="attendanceQuery")
    private String attendanceQuery;
    @Column(name = "feedback")
    private String feedback;
    @Column(name = "registrationNo")
    private String registrationNo;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getClassesHeld() {
        return classesHeld;
    }

    public void setClassesHeld(String classesHeld) {
        this.classesHeld = classesHeld;
    }

    public String getClassesAttented() {
        return classesAttented;
    }

    public void setClassesAttented(String classesAttented) {
        this.classesAttented = classesAttented;
    }

    public String getAttendanceQuery() {
        return attendanceQuery;
    }

    public void setAttendanceQuery(String attendanceQuery) {
        this.attendanceQuery = attendanceQuery;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }
}
