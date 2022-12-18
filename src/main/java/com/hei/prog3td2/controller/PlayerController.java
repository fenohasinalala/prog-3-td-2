package com.hei.prog3td2.controller;

import com.hei.prog3td2.controller.mapper.PlayerMapper;
import com.hei.prog3td2.controller.response.PlayerResponse;
import com.hei.prog3td2.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PlayerController {
    private final PlayerService service;
    private final PlayerMapper mapper;

    @GetMapping("/players")
    public List<PlayerResponse> getPlayers(@RequestParam int page,
                                           @RequestParam(value = "page_size") int pageSize){
        return service.getPlayers(page,pageSize).stream().map(mapper::toRest).toList();
    }

    @GetMapping("/teams/{id}/players")
    public List<PlayerResponse> getPlayersByTeamId(@PathVariable String id){
        return service.getPlayersByTeamId(id).stream().map(mapper::toRest).toList();
    }
}
