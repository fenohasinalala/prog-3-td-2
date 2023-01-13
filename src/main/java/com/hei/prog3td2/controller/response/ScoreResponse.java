package com.hei.prog3td2.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ScoreResponse {
    private int team1_score;
    private int team2_score;
    private List<ScorerResponse> team1_scorers;
    private List<ScorerResponse> team2_scorers;
}
