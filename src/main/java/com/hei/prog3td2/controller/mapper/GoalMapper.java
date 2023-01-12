package com.hei.prog3td2.controller.mapper;

import com.hei.prog3td2.controller.response.GoalResponse;
import com.hei.prog3td2.controller.response.MatchResponse;
import com.hei.prog3td2.model.Match;
import com.hei.prog3td2.model.Score;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class GoalMapper {

    private final PlayerMapper playerMapper;
    public GoalResponse toRest(Score domain){
        return GoalResponse.builder()
                .id(domain.getId())
                .minute(domain.getMinute())
                .player(playerMapper.toRest(domain.getPlayer()))
                .isOnGoal(domain.isOwnGoal())
                .build();
    }
}
