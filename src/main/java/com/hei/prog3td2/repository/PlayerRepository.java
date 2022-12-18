package com.hei.prog3td2.repository;

import com.hei.prog3td2.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,String> {
}
