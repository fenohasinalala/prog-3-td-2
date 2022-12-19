package com.hei.prog3td2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "team")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Team {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    @NotBlank(message = "name is mandatory")
    @Column(unique=true)
    private String name;
    @OneToMany(mappedBy = "team")
    @JsonIgnore
    private List<Player> players;
    @ManyToMany
    @JoinTable(name = "sponsors_teams",
            joinColumns = @JoinColumn(name = "team_id",referencedColumnName = "id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "sponsor_id", referencedColumnName = "id"))
    private List<Sponsor> sponsors;
}
