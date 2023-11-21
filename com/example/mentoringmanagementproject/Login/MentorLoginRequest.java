package com.example.mentoringmanagementproject.login;

public class
MentorLoginRequest {

    private String mentorEmail;
    private String password;

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "MentorLoginRequest{" +
                "mentorEmail='" + mentorEmail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
