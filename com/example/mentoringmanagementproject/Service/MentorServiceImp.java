package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Mentee;
import com.example.mentoringmanagementproject.Mentor;
import com.example.mentoringmanagementproject.ResourceNotFoundException;
import com.example.mentoringmanagementproject.repository.MentorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImp implements MentorService{
    private MentorRepo mentorRepo;
    @Autowired
    public MentorServiceImp(MentorRepo mentorRepo) {
        this.mentorRepo = mentorRepo;
    }

    @Override
    public Mentor saveMentor(Mentor mentor){
        return mentorRepo.save(mentor);
    }
    @Override
    public List<Mentor> getAllMentors(){
        return mentorRepo.findAll();
    }
    public Mentor getMentorById(Long id){
        Optional<Mentor> mentor=mentorRepo.findById(id);
        if(mentor.isPresent()){
            return mentor.get();
        } else {
            throw new ResourceNotFoundException("Mentor", "id",id);
        }
    }


    @Override
    public Mentor updateMentorById(Mentor mentor, Long id){
        Mentor existmentor = mentorRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Mentor","id",id));
        existmentor.setMentorName(mentor.getMentorName());
        existmentor.setMentorId(mentor.getMentorId());
        existmentor.setMentorPhone(mentor.getMentorPhone());
        existmentor.setMentorEmail(mentor.getMentorEmail());
        existmentor.setPassword(mentor.getPassword());
        mentorRepo.save(existmentor);

        return existmentor;
    }

    public Mentor deleteMentorById(Long id) {
        Optional<Mentor> optionalMentor = mentorRepo.findById(id);
        if (optionalMentor.isPresent()) {
            mentorRepo.deleteById(id);
            return optionalMentor.get();
        }
        return null; // Or throw an exception indicating that the mentor with the given id does not exist
    }


    public Optional<Mentor> findBymentorEmailAndPassword(String mentorEmail, String password) {
        return mentorRepo.findBymentorEmailAndPassword(mentorEmail, password);
    }




}
