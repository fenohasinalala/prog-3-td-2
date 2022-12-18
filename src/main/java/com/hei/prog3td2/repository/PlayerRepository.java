package com.hei.prog3td2.repository;

import com.hei.prog3td2.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player,String> {
    List<Player> findAllByTeamId(String id);

    List<Player> findAllByTeamIdOrderByNumberAsc(String id);
}
