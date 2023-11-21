package com.example.mentoringmanagementproject.repository;

import com.example.mentoringmanagementproject.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<Feedback,Long> {
}
