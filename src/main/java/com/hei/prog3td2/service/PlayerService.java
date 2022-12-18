package com.hei.prog3td2.service;

import com.hei.prog3td2.exception.BadRequestException;
import com.hei.prog3td2.model.Player;
import com.hei.prog3td2.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.Sort.Direction.ASC;

@Service
@AllArgsConstructor
public class PlayerService {
    private final PlayerRepository repository;

    public List<Player> getPlayers(int page, int pageSize) {
        if(page<1){
            throw new BadRequestException("page must be >=1");
        }
        if(pageSize>200){
            throw new BadRequestException("page size too large, must be <=200");
        }
        Pageable pageable = PageRequest.of(page - 1,pageSize,
                Sort.by(ASC,"number"));
        return repository.findAll(pageable).toList();
    }

    public List<Player> getPlayersByTeamId(String id) {
        return repository.findAllByTeamIdOrderByNumberAsc(id);
    }
}
