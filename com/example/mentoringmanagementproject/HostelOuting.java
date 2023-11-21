package com.example.mentoringmanagementproject;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table
public class HostelOuting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="studName",nullable = false)
    private String studName;
    @Column(name="registrationNo")
    private String registrationNo;
    @Column(name="parentName")
    private String parentName;
    @Column(name="parentNo")
    private String parentNo;
    @Column(name = "outingPurpose")
    private String outingPurpose;
    @Column(name = "mentorName")
    private String mentorName;
    @Column(name = "branch")
    private String branch;
    @Column(name = "hostelNo")
    private String hostelNo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudName() {
        return studName;
    }

    public void setStudName(String studName) {
        this.studName = studName;
    }

    public String getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(String registrationNo) {
        this.registrationNo = registrationNo;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }

    public String getOutingPurpose() {
        return outingPurpose;
    }

    public void setOutingPurpose(String outingPurpose) {
        this.outingPurpose = outingPurpose;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getHostelNo() {
        return hostelNo;
    }

    public void setHostelNo(String hostelNo) {
        this.hostelNo = hostelNo;
    }
}
