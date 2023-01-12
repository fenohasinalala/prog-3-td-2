package com.hei.prog3td2.repository;

import com.hei.prog3td2.model.Match;
import com.hei.prog3td2.model.Score;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreRepository extends JpaRepository<Score,String> {
    List<Score> findAllByMatchIdOrderByMinuteAsc(String id);
}
