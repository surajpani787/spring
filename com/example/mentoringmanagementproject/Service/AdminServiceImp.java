package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Admin;
import com.example.mentoringmanagementproject.ResourceNotFoundException;
import com.example.mentoringmanagementproject.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImp implements AdminService{
    private AdminRepo adminRepo;
    @Autowired
    public AdminServiceImp(AdminRepo adminRepo) {
        this.adminRepo = adminRepo;
    }
    @Override
    public Admin saveAdmin(Admin admin){

        return adminRepo.save(admin);
    }
    @Override
    public List<Admin> getAllAdmins(){
        return adminRepo.findAll();
    }
    @Override
    public Admin getAdminById(Long id){
        Optional<Admin> admin = adminRepo.findById(id);
        if (admin.isPresent()){
            return admin.get();
        }else{
            throw new ResourceNotFoundException("Admin","id",id);
        }
    }
    @Override
    public Admin updateAdminById(Admin admin, Long id){
        Admin existadmin = adminRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Admin","id",id));
        existadmin.setAdminName(admin.getAdminName());
        existadmin.setAdminEmail(admin.getAdminEmail());
        existadmin.setPassword(admin.getPassword());
        adminRepo.save(existadmin);
        return existadmin;
    }

}
