package com.scrop.dropnow.converter;

import com.scrop.dropnow.entity.DropNow_Entity;
import com.scrop.dropnow.model.Sign_in;
import org.springframework.stereotype.Component;

@Component
public class Converter {
    public DropNow_Entity convertDtoToEntity(Sign_in signin){
        DropNow_Entity entity = new DropNow_Entity();
        entity.setName(signin.getName());
        entity.setEmailId(signin.getEmailId());
        entity.setPassword(signin.getPassword());
        return entity ;
    }
    public Sign_in convertEntityToDto(DropNow_Entity entity){
        Sign_in signin = new Sign_in();
        signin.setId(entity.getId());
        signin.setName(entity.getName());
        signin.setEmailId(entity.getEmailId());
        signin.setPassword(entity.getPassword());
        return signin;
    }
}
