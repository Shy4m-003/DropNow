package com.scrop.dropnow.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor

public class BusinessException extends RuntimeException{
    private List<ErrorModel> errors;
    public BusinessException(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
