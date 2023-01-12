package com.hei.prog3td2.controller.mapper;

import com.hei.prog3td2.controller.response.MatchResponse;
import com.hei.prog3td2.model.Match;
import com.hei.prog3td2.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MatchMapper {

    private final TeamMapper teamMapper;
    private final ScoreService scoreService;

    public MatchResponse toRest(Match domain){
        return MatchResponse.builder()
                .id(domain.getId())
                .datetime(domain.getDatetime().toString())
                .team1(teamMapper.toRest(domain.getTeam1()))
                .team2(teamMapper.toRest(domain.getTeam2()))
                .score(scoreService.getScoreByMatchId(domain.getId()))
                .build();
    }
}
