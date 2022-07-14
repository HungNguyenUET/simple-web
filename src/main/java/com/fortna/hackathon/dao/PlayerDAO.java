package com.fortna.hackathon.dao;

import com.fortna.hackathon.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDAO extends CrudRepository<Player, Long> {
}
