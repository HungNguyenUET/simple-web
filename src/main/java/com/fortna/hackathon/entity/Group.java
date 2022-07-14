package com.fortna.hackathon.entity;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "GROUP_INFO")
@NoArgsConstructor
public class Group {
    @Id
    @Column(name = "ID") @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUP_GENERATOR")
    @SequenceGenerator(name = "GROUP_GENERATOR", sequenceName = "GROUP_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private List<Player> players;

    public Group(String name, Long[] playerIds) {
        this.winnerId = -1L;
        this.name = name;

        HashSet<Long> playerIdSet = new HashSet<>(Arrays.asList(playerIds));
        players = new ArrayList<>();

        playerIdSet.forEach(playerId -> {
            Player player = new Player(playerId);
            players.add(player);
        });
    }

    public Long[][] getMatchPlayerIds() {
        int playerNum = players.size();
        int numberOfMatch = playerNum*(playerNum -1)/2;

        Long[][] matchPlayerIds = new Long[numberOfMatch][2];

        int count = 0;
        for (int i = 0; i < playerNum - 1; i++) {
            for (int j = i + 1; j < playerNum; j++) {
                matchPlayerIds[count][0] = players.get(i).getUserId();
                matchPlayerIds[count][1] = players.get(j).getUserId();
                count++;
            }
        }

        return matchPlayerIds;
    }

    public Long getTopPlayerId() {
        Collections.sort(players);
        return players.get(0).getUserId();
    }

}
