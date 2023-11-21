package com.example.mentoringmanagementproject.repository;

import com.example.mentoringmanagementproject.Mentee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenteeRepo extends JpaRepository<Mentee, Long> {

    Optional<Mentee> findByStudentEmailAndPassword(String studentEmail, String password);

}
