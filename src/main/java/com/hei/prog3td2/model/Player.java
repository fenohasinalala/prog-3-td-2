package com.hei.prog3td2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "player")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Player {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    @NotBlank(message = "name is mandatory")
    @Column(unique=true)
    private String name;
    private Integer number;
    @ManyToOne
    @JoinColumn(name = "team_id")
    @NotNull(message = "team is mandatory")
    private Team team;
}
