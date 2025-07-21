package com.scrop.dropnow.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCardDto {
    private Long userId;
    private String name;
    private String vehicleType;
    private String pickUp;
    private String drop;
    private double distance;
    private double fare;
    private double timeMultiplier;
}
