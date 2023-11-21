package com.example.mentoringmanagementproject.repository;

import com.example.mentoringmanagementproject.Feedback;
import com.example.mentoringmanagementproject.HostelOuting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostelRepo extends JpaRepository<HostelOuting,Long> {
}
