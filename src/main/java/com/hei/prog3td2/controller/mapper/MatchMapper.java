package com.hei.prog3td2.controller.mapper;

import com.hei.prog3td2.controller.response.MatchResponse;
import com.hei.prog3td2.controller.response.ScoreResponse;
import com.hei.prog3td2.model.Match;
import com.hei.prog3td2.service.ScoreService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class MatchMapper {

    private final TeamMapper teamMapper;
    private final ScoreService scoreService;

    private final ScorerMapper scorerMapper;

    public MatchResponse toRest(Match domain){

        ScoreResponse score = ScoreResponse.builder()
                .team1_score(domain.getTeam1Score())
                .team1_scorers(domain.getTeam1Scorers().stream().map(scorerMapper::toRest).toList())
                .team2_score(domain.getTeam2Score())
                .team2_scorers(domain.getTeam2Scorers().stream().map(scorerMapper::toRest).toList())
                .build();
        return MatchResponse.builder()
                .id(domain.getId())
                .datetime(domain.getDatetime().toString())
                .team1(teamMapper.toRest(domain.getTeam1()))
                .team2(teamMapper.toRest(domain.getTeam2()))
                //.score(scoreService.getScoreByMatchId(domain.getId()))
                .score(score)
                .build();
    }
}
