package com.admin.Service.Impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.admin.Clint.ClintRequest;
import com.admin.Entity.Request.Admin;
import com.admin.Entity.Request.HttpRequestData;
import com.admin.Entity.Response.AdminResponse;
import com.admin.repo.AdminRepo;

@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
    private AdminRepo repository;
	
	ClintRequest clientconfig =new ClintRequest();
	
	public AdminResponse createAdmin(Admin admin) {
		return new AdminResponse(LocalDate.now(),"sucess",repository.save(admin));
	}
	public String verifyUser() {
		HttpRequestData httpdata = new HttpRequestData("GET","http://localhost:8281" ,"/api/users", null, null);
		
		try {
			String response = clientconfig.getData(httpdata);
			return response;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Error";
	}

}
