package com.hei.prog3td2.controller.mapper;

import com.hei.prog3td2.controller.response.PlayerResponse;
import com.hei.prog3td2.model.Player;
import org.springframework.stereotype.Component;

@Component
public class PlayerMapper {
    public PlayerResponse toRest(Player domain){
        return PlayerResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }
}
