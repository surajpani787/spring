package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Feedback;
import com.example.mentoringmanagementproject.HostelOuting;

import java.util.List;

public interface HostelService {


    HostelOuting saveHostelOuting(HostelOuting hostelOuting);
    public List<HostelOuting> getAllHostelOutings();
    public HostelOuting getHostelOutingById(Long Id);
    public HostelOuting updateHostelOutingById(HostelOuting hostel_outing, Long id);

}
