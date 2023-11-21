package com.example.mentoringmanagementproject.Controller;

import com.example.mentoringmanagementproject.Mentee;
import com.example.mentoringmanagementproject.Service.MenteeService;
import com.example.mentoringmanagementproject.login.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/mentee")
public class MenteeController {

    private MenteeService menteeService;
    @Autowired
    public MenteeController(MenteeService menteeService) {
        this.menteeService = menteeService;
    }
    @PostMapping("/signup")
    public ResponseEntity<Mentee> saveMentee(@RequestBody Mentee mentee){
        return new ResponseEntity<Mentee>(menteeService.saveMentee(mentee), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Mentee> getallMentees(){
        return menteeService.getAllMentees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Mentee>get(@PathVariable("id")Long menteeid) {
        return new ResponseEntity<Mentee>(menteeService.getMenteeById(menteeid), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Mentee>updateMentee(@RequestBody Mentee mentee,@PathVariable("id")Long id){
        return new ResponseEntity<Mentee>(menteeService.updateMenteeById(mentee, id),HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserLoginRequest loginRequest) {
        System.out.println("Received request for LOGIN USER");
        System.out.println(loginRequest);

        Optional<Mentee> optionalMentee = menteeService.findBystudentEmailAndPassword(
                loginRequest.getStudentEmail(),
                loginRequest.getPassword()
        );

        if (optionalMentee.isPresent()) {
            Mentee mentee = optionalMentee.get();
            System.out.println("Login successful!");
            return ResponseEntity.ok(mentee);
        } else {
            System.out.println("Login failed!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}
