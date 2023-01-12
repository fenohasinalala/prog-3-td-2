package com.hei.prog3td2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "score")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Score {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;

    @Min(0)
    @Max(90)
    private int minute;
    @Column(columnDefinition = "boolean default false")
    private boolean isOwnGoal;
    @ManyToOne
    @JoinColumn(name = "match_id")
    @NotNull(message = "match is mandatory")
    private Match match;
    @ManyToOne
    @JoinColumn(name = "player_id")
    @NotNull(message = "player is mandatory")
    private Player player;
}
