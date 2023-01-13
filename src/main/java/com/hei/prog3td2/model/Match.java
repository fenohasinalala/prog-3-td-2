package com.hei.prog3td2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "play_against")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Match {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    private Instant datetime;
    private String Stadium;
    @ManyToOne
    @JoinColumn(name = "team_1_id")
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team_2_id")
    private Team team2;

    @OneToMany(mappedBy = "match")
    @JsonIgnore
    private List<Score> scores;

    public int getTeam1Score() {
        int team1Score = 0;
        for (Score goal : scores) {
            if (Objects.equals(goal.getPlayer().getTeam().getId(), team1.getId()) && !goal.getPlayer().isGoalKeeper()) {
                if (!goal.isOwnGoal()) {
                    team1Score += 1;
                } ;
            } else if (Objects.equals(goal.getPlayer().getTeam().getId(), team2.getId()) && !goal.getPlayer().isGoalKeeper()) {
                if (goal.isOwnGoal()) {
                    team1Score += 1;
                }
            } else
                throw new RuntimeException("Error from database input, because player with Id " + goal.getPlayer().getId() + " that is not in team1 or team2 score a goal during the match");
        }
            return team1Score;
        }

    public int getTeam2Score() {
        int team2Score = 0;
        for (Score goal : scores) {
            if (Objects.equals(goal.getPlayer().getTeam().getId(), team1.getId()) && !goal.getPlayer().isGoalKeeper()) {

                if (!goal.isOwnGoal()) {

                } else team2Score += 1;
            } else if (Objects.equals(goal.getPlayer().getTeam().getId(), team2.getId()) && !goal.getPlayer().isGoalKeeper()) {

                if (!goal.isOwnGoal()) {
                    team2Score += 1;
                }
            } else
                throw new RuntimeException("Error from database input, because player with Id " + goal.getPlayer().getId() + " that is not in team1 or team2 score a goal during the match");
        }
        return team2Score;
    }

    public List<Score> getTeam1Scorers() {
        List<Score> team1_scorers = new ArrayList<>();
        for (Score goal : scores) {
            if (Objects.equals(goal.getPlayer().getTeam().getId(), team1.getId()) && !goal.getPlayer().isGoalKeeper()) {
                if (!goal.isOwnGoal()) {
                    team1_scorers.add(goal);
                }
            } else if (Objects.equals(goal.getPlayer().getTeam().getId(), team2.getId()) && !goal.getPlayer().isGoalKeeper()) {
                if (goal.isOwnGoal()) {
                    team1_scorers.add(goal);
                }
            } else
                throw new RuntimeException("Error from database input, because player with Id " + goal.getPlayer().getId() + " that is not in team1 or team2 score a goal during the match");
        }
        return team1_scorers;
    }

    public List<Score> getTeam2Scorers() {
        List<Score> team2_scorers = new ArrayList<>();
        for (Score goal : scores) {
            if (Objects.equals(goal.getPlayer().getTeam().getId(), team2.getId()) && !goal.getPlayer().isGoalKeeper()) {
                if (!goal.isOwnGoal()) {
                    team2_scorers.add(goal);
                }
            }else if (Objects.equals(goal.getPlayer().getTeam().getId(), team1.getId()) && !goal.getPlayer().isGoalKeeper()) {
                if (goal.isOwnGoal()) {
                    team2_scorers.add(goal);
                }
            } else
                throw new RuntimeException("Error from database input, because player with Id " + goal.getPlayer().getId() + " that is not in team1 or team2 score a goal during the match");
        }
        return team2_scorers;
    }

}
