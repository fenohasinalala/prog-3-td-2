package com.hei.prog3td2.repository;

import com.hei.prog3td2.model.PlayAgainst;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayAgainstRepository extends JpaRepository<PlayAgainst,String> {
}
