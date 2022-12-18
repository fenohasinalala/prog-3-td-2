package com.hei.prog3td2.service;

import com.hei.prog3td2.repository.SponsorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SponsorService {
    private final SponsorRepository repository;
}
