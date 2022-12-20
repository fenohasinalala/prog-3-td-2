package com.hei.prog3td2.controller.response;

import com.hei.prog3td2.model.Sponsor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TeamResponse {
    private String id;
    private String name;
    private List<PlayerResponse> players;
    private List<Sponsor> sponsors;
}
