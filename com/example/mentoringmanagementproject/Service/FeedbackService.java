package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Admin;
import com.example.mentoringmanagementproject.Feedback;
import com.example.mentoringmanagementproject.Mentee;

import java.util.List;

public interface FeedbackService {

    Feedback saveFeedback(Feedback feedback);


    public List<Feedback> getAllFeedbacks();
    public Feedback getFeedbackById(Long id);
    public Feedback updateFeedbackById(Feedback feedback, Long id);

}
