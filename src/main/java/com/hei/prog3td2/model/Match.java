package com.hei.prog3td2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.Instant;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "play_against")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Match {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    private Instant datetime;
    private String Stadium;
    @ManyToOne
    @JoinColumn(name = "team_1_id")
    private Team team1;

    @ManyToOne
    @JoinColumn(name = "team_2_id")
    private Team team2;
}
