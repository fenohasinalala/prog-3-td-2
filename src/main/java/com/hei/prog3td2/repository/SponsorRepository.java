package com.hei.prog3td2.repository;

import com.hei.prog3td2.model.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor,String> {
}
