package com.hei.prog3td2.service;

import com.hei.prog3td2.exception.BadRequestException;
import com.hei.prog3td2.model.Player;
import com.hei.prog3td2.model.Team;
import com.hei.prog3td2.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Service
@AllArgsConstructor
public class TeamService {
    private final TeamRepository repository;
    private final PlayerService playerService;

    public List<Team> getTeams(int page, int pageSize) {
        if(page<1){
            throw new BadRequestException("page must be >=1");
        }
        if(pageSize>200){
            throw new BadRequestException("page size too large, must be <=200");
        }
        Pageable pageable = PageRequest.of(page - 1,pageSize,
                Sort.by(ASC,"name"));
        List<Team> result = repository.findAll(pageable).toList();
        for (Team t:result) {
            List<Player> sortedPlayers = playerService.getPlayersByTeamId(t.getId());
            t.setPlayers(sortedPlayers);
        }
        return result;
    }
}
