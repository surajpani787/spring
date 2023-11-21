package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Feedback;
import com.example.mentoringmanagementproject.HostelOuting;
import com.example.mentoringmanagementproject.ResourceNotFoundException;
import com.example.mentoringmanagementproject.repository.FeedbackRepo;
import com.example.mentoringmanagementproject.repository.HostelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class HostelOutingServiceImp implements  HostelService{

    private HostelRepo hostelRepo;
    @Autowired
    public HostelOutingServiceImp(HostelRepo hostelRepo) {
        this.hostelRepo = hostelRepo;
    }

    @Override
    public HostelOuting saveHostelOuting(HostelOuting hostelOuting){
        return hostelRepo.save(hostelOuting);
    }



    @Override
    public List<HostelOuting> getAllHostelOutings(){
        return hostelRepo.findAll();
    }

    public HostelOuting getHostelOutingById(Long id){
        Optional<HostelOuting> hostelOuting=hostelRepo.findById(id);
        if(hostelOuting.isPresent()){
            return hostelOuting.get();
        } else {
            throw new ResourceNotFoundException("Mentor", "id",id);
        }
    }
    @Override
    public HostelOuting updateHostelOutingById(HostelOuting hostelOuting, Long id){
        HostelOuting existhostelOuting = hostelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Feedback","id",id));
        existhostelOuting.setStudName(hostelOuting.getStudName());
        existhostelOuting.setRegistrationNo(hostelOuting.getRegistrationNo());
        existhostelOuting.setParentName(hostelOuting.getParentName());
        existhostelOuting.setParentNo(hostelOuting.getParentNo());
        existhostelOuting.setOutingPurpose(hostelOuting.getOutingPurpose());
        existhostelOuting.setMentorName(hostelOuting.getMentorName());
        existhostelOuting.setBranch(hostelOuting.getBranch());
        existhostelOuting.setHostelNo(hostelOuting.getHostelNo());
        hostelRepo.save(existhostelOuting);

        return existhostelOuting;
    }

}
