package com.fortna.hackathon.controller;

import com.fortna.hackathon.dto.AppResponse;
import com.fortna.hackathon.dto.CreateGroupDto;
import com.fortna.hackathon.entity.Group;
import com.fortna.hackathon.service.GroupService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/group")
public class GroupController {

    private GroupService service;

    public GroupController(GroupService service) {
        this.service = service;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createGroup(@RequestBody CreateGroupDto createGroupDto) {
        if (createGroupDto == null || (createGroupDto.getPlayerIds() == null)
                || (createGroupDto.getName() == null) || (createGroupDto.getPlayerIds().length == 0)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AppResponse("Invalid body request", null));
        }

        if (!service.createGroup(createGroupDto)) {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AppResponse("Invalid body request", null));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(null, "Create group successfully!"));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAllGroups() {
        List<Group> groups = service.getAllGroups();
        return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(null, groups));
    }

    @GetMapping(value = "group-math-player", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getGroupMatchPlayer(@RequestParam("group_id") Long groupId) {
        return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(null, service.getGroupMathPlayers(groupId)));
    }

    public ResponseEntity<?> getTopPlayerOfGroup(@RequestParam("group_id") Long groupId){
        Long topPlayerId = service.getTopPlayerOfGroup(groupId);
        return ResponseEntity.status(HttpStatus.OK).body(new AppResponse(null, topPlayerId));
    }

}
