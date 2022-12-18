package com.hei.prog3td2.repository;

import com.hei.prog3td2.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,String> {
}
