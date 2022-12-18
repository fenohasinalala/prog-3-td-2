package com.hei.prog3td2.controller;

import com.hei.prog3td2.controller.mapper.TeamMapper;
import com.hei.prog3td2.controller.response.TeamResponse;
import com.hei.prog3td2.service.TeamService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class TeamController {
    private final TeamService service;
    private final TeamMapper mapper;

    @GetMapping("/teams")
    public List<TeamResponse> getTeams(@RequestParam int page,
                                         @RequestParam(value = "page_size") int pageSize){
        return service.getTeams(page,pageSize).stream().map(mapper::toRest).toList();
    }

}
