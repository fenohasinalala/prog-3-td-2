package com.hei.prog3td2.controller;

import com.hei.prog3td2.controller.mapper.MatchMapper;
import com.hei.prog3td2.controller.response.MatchResponse;
import com.hei.prog3td2.service.MatchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class MatchController {
    private final MatchService service;
    private final MatchMapper mapper;

    @GetMapping("/matchs")
    public List<MatchResponse> getMatchs(@RequestParam int page,
                                        @RequestParam(value = "page_size") int pageSize){
        return service.getMatchs(page,pageSize).stream().map(mapper::toRest).toList();
    }

}
