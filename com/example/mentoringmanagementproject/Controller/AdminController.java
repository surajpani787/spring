package com.example.mentoringmanagementproject.Controller;


import com.example.mentoringmanagementproject.Admin;
import com.example.mentoringmanagementproject.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private AdminService adminService;
    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public ResponseEntity<Admin> saveAdmin(@RequestBody Admin admin){
        return new ResponseEntity<Admin>(adminService.saveAdmin(admin), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Admin> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("{id}")
    public ResponseEntity<Admin>getAdmin(@PathVariable("id")Long id){
        return new ResponseEntity<Admin>(adminService.getAdminById(id),HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Admin>updateAdminById(@RequestBody Admin admin,@PathVariable("id")Long id){
        return new ResponseEntity<Admin>(adminService.updateAdminById(admin,id),HttpStatus.OK);
    }

}
