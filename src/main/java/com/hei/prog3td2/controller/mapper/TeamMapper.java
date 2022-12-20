package com.hei.prog3td2.controller.mapper;

import com.hei.prog3td2.controller.response.TeamResponse;
import com.hei.prog3td2.model.Team;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class TeamMapper {
    private final PlayerMapper playerMapper;
    public TeamResponse toRest(Team domain){
        return TeamResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .players(domain.getPlayers().size()>0?domain.getPlayers().stream().map(e->playerMapper.toRest(e)).toList():new ArrayList<>())
                .sponsors(domain.getSponsors().size()>0?domain.getSponsors():new ArrayList<>())
                .build();
    }
}
