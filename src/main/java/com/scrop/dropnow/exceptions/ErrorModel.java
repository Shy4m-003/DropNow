package com.scrop.dropnow.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorModel {
    private String code;
    private String message;
}
