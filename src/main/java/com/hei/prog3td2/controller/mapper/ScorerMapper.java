package com.hei.prog3td2.controller.mapper;

import com.hei.prog3td2.controller.response.ScorerResponse;
import com.hei.prog3td2.model.Score;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ScorerMapper {

    private final PlayerMapper playerMapper;
    public ScorerResponse toRest(Score domain){
        return ScorerResponse.builder()
                .id(domain.getId())
                .minute(domain.getMinute())
                .player(playerMapper.toRest(domain.getPlayer()))
                .isOnGoal(domain.isOwnGoal())
                .build();
    }
}
