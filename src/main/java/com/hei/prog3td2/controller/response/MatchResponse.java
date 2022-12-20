package com.hei.prog3td2.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MatchResponse {
    private String id;
    private String datetime;
    private TeamResponse team1;
    private TeamResponse team2;
}
