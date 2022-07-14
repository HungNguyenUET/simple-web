package com.fortna.hackathon.dao;

import com.fortna.hackathon.entity.Group;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupDAO extends CrudRepository<Group, Long> {

    List<Group> findAll();

}
