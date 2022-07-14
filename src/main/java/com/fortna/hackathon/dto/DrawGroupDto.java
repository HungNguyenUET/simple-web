package com.fortna.hackathon.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class DrawGroupDto {

    @NotEmpty
    private Integer groupNum;

    @NotEmpty
    private Integer userNum;

}
