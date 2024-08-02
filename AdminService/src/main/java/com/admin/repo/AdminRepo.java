package com.admin.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.admin.Entity.Request.Admin;

@Repository
public interface AdminRepo extends MongoRepository<Admin, String> {
	
}