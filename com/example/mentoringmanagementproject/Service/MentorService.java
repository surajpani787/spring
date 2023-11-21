package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Mentee;
import com.example.mentoringmanagementproject.Mentor;

import java.util.List;
import java.util.Optional;

public interface MentorService {
    public Mentor saveMentor(Mentor mentor);
    public List<Mentor> getAllMentors();
    public Mentor getMentorById(Long Id);
    public Mentor updateMentorById(Mentor mentor, Long id);
    public Mentor deleteMentorById(Long id);

    Optional<Mentor> findBymentorEmailAndPassword(String mentorEmail, String password);





}
