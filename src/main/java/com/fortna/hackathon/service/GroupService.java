package com.fortna.hackathon.service;

import com.fortna.hackathon.dto.CreateGroupDto;
import com.fortna.hackathon.entity.Group;

import java.util.List;

public interface GroupService {

    boolean createGroup(CreateGroupDto createGroupDto);

    List<Group> getAllGroups();

    boolean updateGroup();

    public Long[][] getGroupMathPlayers(Long groupId);

    public Long getTopPlayerOfGroup(Long groupId);

}
