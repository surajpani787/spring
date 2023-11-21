package com.example.mentoringmanagementproject.Controller;

import com.example.mentoringmanagementproject.Mentee;
import com.example.mentoringmanagementproject.Mentor;
import com.example.mentoringmanagementproject.Service.MentorService;
import com.example.mentoringmanagementproject.login.MentorLoginRequest;
import com.example.mentoringmanagementproject.login.UserLoginRequest;
import com.example.mentoringmanagementproject.repository.MenteeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/mentor")
public class MentorController {

    private MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @PostMapping("/addmentor")
    public ResponseEntity<Mentor> saveMentor(@RequestBody Mentor mentor) {
        return new ResponseEntity<>(mentorService.saveMentor(mentor), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Mentor> getAllMentors() {
        return mentorService.getAllMentors();
    }

    @GetMapping("{id}")
    public ResponseEntity<Mentor> get(@PathVariable("id") Long mentorid) {
        return new ResponseEntity<>(mentorService.getMentorById(mentorid), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Mentor> updateMentor(@RequestBody Mentor mentor, @PathVariable("id") Long id) {
        return new ResponseEntity<>(mentorService.updateMentorById(mentor, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Mentor deleteMentorById(@PathVariable Long id) {
        return mentorService.deleteMentorById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginMentor(@RequestBody MentorLoginRequest loginRequest) {
        System.out.println("Received request for LOGIN Mentor");
        System.out.println(loginRequest);

        Optional<Mentor> optionalMentor = mentorService.findBymentorEmailAndPassword(
                loginRequest.getMentorEmail(),
                loginRequest.getPassword()
        );

        if (optionalMentor.isPresent()) {
            Mentor mentor = optionalMentor.get();
            System.out.println("Login successful!");
            return ResponseEntity.ok(mentor);
        } else {
            System.out.println("Login failed!");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
