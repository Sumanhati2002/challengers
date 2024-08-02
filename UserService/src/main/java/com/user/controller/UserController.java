package com.user.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.generateotp.OtpGenarator;
import com.user.model.ChangePasswordRequest;
import com.user.model.User;
import com.user.model.responce.UserResponce;
import com.user.repo.UserRepo;
import com.user.rest.RequestPath;
import com.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private OtpGenarator otpgenerator;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private UserService userService;

	@PostMapping(value = RequestPath.USER_CREATE)
	public UserResponce createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@GetMapping(value = RequestPath.USER_GET)
	public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping(value = RequestPath.GET_USERS)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping(value = RequestPath.USER_UPDATE)
	public ResponseEntity<User> updateUser(@PathVariable("id") String id, @RequestBody User user) {
		user.setId(id);
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping(value = RequestPath.USER_DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
		userService.deleteUser(id);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
	
	//send otp
	@GetMapping("/hii")
	public void sendOTPEmail() {
		User user=new User();
		user.setPhoneNumber("7364052970");
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(user.getPhoneNumber());
		message.setSubject("Your OTP");
		message.setText("Your OTP is: " + OtpGenarator.generateOTP());
		System.out.println(message);
		javaMailSender.send(message);	
	}
	
	//change password by taking old password
	@PostMapping("/changepassword")
	public  ResponseEntity<User> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
		String existingPassword=changePasswordRequest.getUser().getPassword();
		if (existingPassword.contains(changePasswordRequest.getOldPassword())) {
			changePasswordRequest.getUser().setPassword(changePasswordRequest.getNewPassword());
			this.userRepo.save(changePasswordRequest.getUser());
		}
		else {
			System.out.println("invalid user password");
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
