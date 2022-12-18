package com.hei.prog3td2.controller.mapper;

import com.hei.prog3td2.controller.response.MatchResponse;
import com.hei.prog3td2.model.Match;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {
    public MatchResponse toRest(Match domain){
        return MatchResponse.builder()
                .id(domain.getId())
                .datetime(domain.getDatetime().toString())
                .team1(domain.getTeam1().getName())
                .team2(domain.getTeam2().getName())
                .build();
    }
}
