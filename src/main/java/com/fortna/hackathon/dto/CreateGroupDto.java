package com.fortna.hackathon.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateGroupDto {
    private Long[] playerIds;

    private String name;
}
