package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Feedback;
import com.example.mentoringmanagementproject.ResourceNotFoundException;
import com.example.mentoringmanagementproject.repository.FeedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImp implements FeedbackService{
    private FeedbackRepo feedbackRepo;
    @Autowired
    public FeedbackServiceImp(FeedbackRepo feedbackRepo) {
        this.feedbackRepo = feedbackRepo;
    }

    @Override
    public Feedback saveFeedback(Feedback feedback){
        return feedbackRepo.save(feedback);
    }



    @Override
    public List<Feedback> getAllFeedbacks(){
        return feedbackRepo.findAll();
    }

    public Feedback getFeedbackById(Long id){
        Optional<Feedback> feedback=feedbackRepo.findById(id);
        if(feedback.isPresent()){
            return feedback.get();
        } else {
            throw new ResourceNotFoundException("Mentor", "id",id);
        }
    }
    @Override
    public Feedback updateFeedbackById(Feedback feedback, Long id){
        Feedback existfeedback = feedbackRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Feedback","id",id));
        existfeedback.setSubject(feedback.getSubject());
        existfeedback.setClassesHeld(feedback.getClassesHeld());
        existfeedback.setClassesAttented(feedback.getClassesAttented());
        existfeedback.setAttendanceQuery(feedback.getAttendanceQuery());
        existfeedback.setFeedback(feedback.getFeedback());
        existfeedback.setRegistrationNo(feedback.getRegistrationNo());
        feedbackRepo.save(existfeedback);

        return existfeedback;
    }
}
