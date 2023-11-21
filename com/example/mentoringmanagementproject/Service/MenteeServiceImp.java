package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Mentee;
import com.example.mentoringmanagementproject.ResourceNotFoundException;
import com.example.mentoringmanagementproject.repository.MenteeRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenteeServiceImp implements MenteeService {

    private static final Logger log = LoggerFactory.getLogger(MenteeServiceImp.class);
    private final MenteeRepo menteeRepo;

    @Autowired
    public MenteeServiceImp(MenteeRepo menteeRepo) {
        this.menteeRepo = menteeRepo;
    }

    @Override
    public Mentee saveMentee(Mentee mentee) {
        return menteeRepo.save(mentee);
    }

    @Override
    public List<Mentee> getAllMentees() {
        return menteeRepo.findAll();
    }

    @Override
    public Mentee getMenteeById(Long id) {
        Optional<Mentee> mentee = menteeRepo.findById(id);
        if (mentee.isPresent()) {
            return mentee.get();
        } else {
            throw new ResourceNotFoundException("Mentee", "id", id);
        }
    }

    @Override
    public Mentee updateMenteeById(Mentee mentee, Long id) {
        Mentee existMentee = menteeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mentee", "id", id));

        // Update fields
        existMentee.setStudentName(mentee.getStudentName());
        existMentee.setStudentRegdNo(mentee.getStudentRegdNo());
        existMentee.setStudentPhone(mentee.getStudentPhone());
        existMentee.setStudentEmail(mentee.getStudentEmail());
        existMentee.setParentName(mentee.getParentName());
        existMentee.setParentNo(mentee.getParentNo());
        existMentee.setPassword(mentee.getPassword());

        menteeRepo.save(existMentee);

        return existMentee;
    }

    @Override
    public Optional<Mentee> findBystudentEmailAndPassword(String studentEmail, String password) {
        return menteeRepo.findByStudentEmailAndPassword(studentEmail, password);
    }

}
