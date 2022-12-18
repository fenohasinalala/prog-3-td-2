package com.hei.prog3td2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "sponsor")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Sponsor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private String id;
    @NotBlank(message = "name is mandatory")
    private String name;
}
