package com.scrop.dropnow.service;

import com.scrop.dropnow.converter.Converter;
import com.scrop.dropnow.entity.DropNow_Entity;
import com.scrop.dropnow.repository.DropNow_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scrop.dropnow.model.Sign_in;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class Signin_Logic implements DropService {
	@Autowired
	private DropNow_Repository dropNowRepository;
	@Autowired
	private Converter converter;
	@Override
	public Sign_in Create_Account(Sign_in signin) {
		DropNow_Entity entity = converter.convertDtoToEntity(signin);
		System.out.println("DEBUG - DTO Email: " + signin.getEmailId());
		System.out.println("DEBUG - Entity Email: " + entity.getEmailId());
		System.out.println("Saving entity: " + entity);
		entity = dropNowRepository.save(entity);
		 signin = converter.convertEntityToDto(entity);
		return signin;
		// TODO Auto-generated method stub
	}

	@Override
	public List<Sign_in> getAllInfo() {
		List <DropNow_Entity> list = (List <DropNow_Entity>)dropNowRepository.findAll();
		List<Sign_in> allList = new ArrayList<>();
		for(DropNow_Entity entity : list){
			Sign_in signin =converter.convertEntityToDto(entity);
			allList.add(signin);
		}
		return allList;
	}

	@Override
	public Sign_in updateUserDetails(Sign_in signIn, Long userId) {
		Optional<DropNow_Entity> entityOptional =  dropNowRepository.findById(userId);
		Sign_in sign_in = null;
		if(entityOptional.isPresent()){
			DropNow_Entity entity = entityOptional.get();
			entity.setName(signIn.getName());
			entity.setEmailId(signIn.getEmailId());
			entity.setPassword(signIn.getPassword());
			sign_in = converter.convertEntityToDto(entity);
			dropNowRepository.save(entity);
		}
		return sign_in;

	}

	@Override
	public Sign_in updateName(Sign_in sign_in, long userId) {
		Optional<DropNow_Entity> entityOptional =  dropNowRepository.findById(userId);
		Sign_in signIn = null;
		if(entityOptional.isPresent()){
			DropNow_Entity entity = entityOptional.get();
			entity.setName(sign_in.getName());
			signIn = converter.convertEntityToDto(entity);
			dropNowRepository.save(entity);
		}
		return signIn;
	}

	@Override
	public void deleteUserDetails(Long userId) {
		dropNowRepository.deleteById(userId);
	}
}
