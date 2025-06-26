package com.scrop.dropnow.service;

import com.scrop.dropnow.model.Sign_in;
import org.hibernate.sql.Update;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DropService {
	 Sign_in Create_Account(Sign_in signin);
	 List<Sign_in> getAllInfo();
	 Sign_in updateUserDetails(Sign_in signIn,Long userId);
	 Sign_in updateName(@RequestBody Sign_in sign_in, long userId);
	 void deleteUserDetails(Long userId);
}
