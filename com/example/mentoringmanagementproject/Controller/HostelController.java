package com.example.mentoringmanagementproject.Controller;


import com.example.mentoringmanagementproject.Feedback;
import com.example.mentoringmanagementproject.HostelOuting;
import com.example.mentoringmanagementproject.Service.FeedbackService;
import com.example.mentoringmanagementproject.Service.HostelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/hostelouting")
public class HostelController {

    private HostelService hostelService;
    @Autowired
    public HostelController(HostelService hostelService) {
        this.hostelService = hostelService;
    }

    @PostMapping
    public ResponseEntity<HostelOuting> saveHostelOuting(@RequestBody HostelOuting hostelOuting){
        return new ResponseEntity<HostelOuting>(hostelService.saveHostelOuting(hostelOuting), HttpStatus.CREATED);
    }
    @GetMapping
    public List<HostelOuting> getAllHostelOutings(){return hostelService.getAllHostelOutings();
    }

    @GetMapping("{id}")
    public ResponseEntity<HostelOuting>getHostelOuting(@PathVariable("id")Long id){
        return new ResponseEntity<HostelOuting>(hostelService.getHostelOutingById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<HostelOuting>updateHostelOutingById(@RequestBody HostelOuting hostelOuting,@PathVariable("id")Long id){
        return new ResponseEntity<HostelOuting>(hostelService.updateHostelOutingById(hostelOuting,id),HttpStatus.OK);
    }


}
