package com.scrop.dropnow.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorModel>> handleFieldValidation(MethodArgumentNotValidException manv){
        List<ErrorModel> errorModelList = new ArrayList<>();
        ErrorModel errorModel = null;
        List<FieldError> fieldError = manv.getBindingResult().getFieldErrors();
        for(FieldError fe  : fieldError){
            logger.debug("Inside Field Validation {} - {}",fe.getField(),fe.getDefaultMessage());
            logger.info("Inside Field Validation {} - {}",fe.getField(),fe.getDefaultMessage());
            errorModel = new ErrorModel();
            errorModel.setCode(fe.getField());
            errorModel.setMessage((fe.getDefaultMessage()));
            errorModelList.add(errorModel);
        }
        return new ResponseEntity<>(errorModelList, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<List<ErrorModel>> handleBusinessException(BusinessException businessException){
        for(ErrorModel em : businessException.getErrors()){
            logger.debug("Business Exception is Thrown - level-Debug : {} - {}",em.getCode(),em.getMessage());
            logger.info("Business Exception is Thrown - level-info: {} - {}",em.getCode(),em.getMessage());
            logger.warn("Business Exception is Thrown -level-warn: {} - {}",em.getCode(),em.getMessage());
            logger.error("Business Exception is Thrown -level-error : {} - {}",em.getCode(),em.getMessage());
        }
        return new ResponseEntity<>(businessException.getErrors(), HttpStatus.BAD_REQUEST);
    }
}
