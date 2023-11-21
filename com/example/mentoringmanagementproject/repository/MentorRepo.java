package com.example.mentoringmanagementproject.repository;

import com.example.mentoringmanagementproject.Mentee;
import com.example.mentoringmanagementproject.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MentorRepo extends JpaRepository<Mentor,Long> {
    Optional<Mentor> findBymentorEmailAndPassword(String mentorEmail, String password);

}
