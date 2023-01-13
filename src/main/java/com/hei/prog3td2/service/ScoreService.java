package com.hei.prog3td2.service;

import com.hei.prog3td2.controller.mapper.ScorerMapper;
import com.hei.prog3td2.controller.response.ScoreResponse;
import com.hei.prog3td2.model.Match;
import com.hei.prog3td2.model.Score;
import com.hei.prog3td2.repository.PlayerRepository;
import com.hei.prog3td2.repository.ScoreRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScoreService {
    private final ScoreRepository repository;
    private final MatchService matchService;
    private final ScorerMapper scorerMapper;
    private final PlayerRepository playerRepository;
    public List<Score> getGoalsByMatchId(String id) {
        Match match = matchService.getMatchById(id);
        return repository.findAllByMatchIdOrderByMinuteAsc(match.getId());
    }

    public ScoreResponse getScoreByMatchId(String id) {

        Match match = matchService.getMatchById(id);

        int team1Score = 0;
        int team2Score = 0;

        List<Score> allGoals = getGoalsByMatchId(id);
        List<Score> team1_scorers = new ArrayList<>(),team2_scorers = new ArrayList<>();

        for (Score goal:allGoals) {
            if (goal.getPlayer().getTeam().getId() == match.getTeam1().getId() ){
                team1_scorers.add(goal);
                if (!goal.isOwnGoal()){
                    team1Score +=1;
                }else team2Score +=1;
            } else if (goal.getPlayer().getTeam().getId() == match.getTeam2().getId() ) {
                team2_scorers.add(goal);
                if (!goal.isOwnGoal()){
                    team2Score +=1;
                }else team1Score +=1;
            } else throw new RuntimeException("Error from database input, because player with Id "+goal.getPlayer().getId()+" that is not in team1 or team2 score a goal during the match");

        }

        return ScoreResponse.builder()
                .team1_score(team1Score)
                .team2_score(team2Score)
                .team1_scorers(team1_scorers.stream().map(scorerMapper::toRest).toList())
                .team2_scorers(team2_scorers.stream().map(scorerMapper::toRest).toList())
                .build();
    }
}
