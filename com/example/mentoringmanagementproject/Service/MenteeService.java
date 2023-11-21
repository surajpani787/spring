package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Mentee;

import java.util.List;
import java.util.Optional;

public interface MenteeService {
    Mentee saveMentee(Mentee mentee);

    List<Mentee> getAllMentees();

    Mentee getMenteeById(Long id);

    Mentee updateMenteeById(Mentee mentee, Long id);

    Optional<Mentee> findBystudentEmailAndPassword(String studentEmail, String password);
}
