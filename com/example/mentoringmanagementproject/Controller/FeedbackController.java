package com.example.mentoringmanagementproject.Controller;

import com.example.mentoringmanagementproject.Admin;
import com.example.mentoringmanagementproject.Feedback;
import com.example.mentoringmanagementproject.Service.AdminService;
import com.example.mentoringmanagementproject.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/feedback")
public class FeedbackController  {

    private FeedbackService feedbackService;
    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public ResponseEntity<Feedback> saveFeedback(@RequestBody Feedback feedback){
        return new ResponseEntity<Feedback>(feedbackService.saveFeedback(feedback), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Feedback> getAllFeedbacks(){
        return feedbackService.getAllFeedbacks();
    }

    @GetMapping("{id}")
    public ResponseEntity<Feedback>getFeedback(@PathVariable("id")Long id){
        return new ResponseEntity<Feedback>(feedbackService.getFeedbackById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Feedback>updateFeedbackById(@RequestBody Feedback feedback,@PathVariable("id")Long id){
        return new ResponseEntity<Feedback>(feedbackService.updateFeedbackById(feedback,id),HttpStatus.OK);
    }


}
