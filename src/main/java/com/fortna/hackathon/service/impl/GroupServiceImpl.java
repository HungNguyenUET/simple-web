package com.fortna.hackathon.service.impl;

import com.fortna.hackathon.dao.GroupDAO;
import com.fortna.hackathon.dto.CreateGroupDto;
import com.fortna.hackathon.entity.Group;
import com.fortna.hackathon.service.GroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service(value = "groupService")
public class GroupServiceImpl implements GroupService {

    private static final Logger logger = LoggerFactory.getLogger(GroupServiceImpl.class);

    private final GroupDAO groupDAO;

    public GroupServiceImpl(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    @Override
    public boolean createGroup(CreateGroupDto createGroupDto) {
        String name = createGroupDto.getName();
        Long[] playerIds = createGroupDto.getPlayerIds();
        Group newGroup = new Group(name, playerIds);
        groupDAO.save(newGroup);
        return true;
    }

    @Override
    public List<Group> getAllGroups() {
        return groupDAO.findAll();
    }

    @Override
    public boolean updateGroup() {
        return false;
    }

    public Long[][] getGroupMathPlayers(Long groupId) {
        Group group = groupDAO.findById(groupId).orElse(null);
        if (group != null) {
            return group.getMatchPlayerIds();
        }

        return null;
    }

    @Override
    public Long getTopPlayerOfGroup(Long groupId) {
        Group group = groupDAO.findById(groupId).orElse(null);

        if(group == null)
            return -1L;


        return group.getTopPlayerId();
    }
}
