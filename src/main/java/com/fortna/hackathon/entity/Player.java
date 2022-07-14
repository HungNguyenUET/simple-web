package com.fortna.hackathon.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "PLAYER")
@NoArgsConstructor
public class Player implements Comparable<Player> {

    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "SCORE")
    private Integer score;

    public Player(Long userId) {
        this.userId = userId;
        this.score = 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Player player = (Player) obj;
        return player.getUserId().equals(this.userId);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Player player) {
        return this.score.compareTo(player.getScore());
    }

    public void addScore(Integer addScore) {
        if (addScore <= 0)
            return;

        this.score += addScore;
    }
}
