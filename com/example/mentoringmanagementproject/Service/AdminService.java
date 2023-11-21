package com.example.mentoringmanagementproject.Service;

import com.example.mentoringmanagementproject.Admin;

import java.util.List;

public interface AdminService {
    public Admin saveAdmin(Admin admin);
    public List<Admin> getAllAdmins();
    public Admin getAdminById(Long id);
    public Admin updateAdminById(Admin admin, Long id);
}
