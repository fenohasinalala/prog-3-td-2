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
public class GoalResponse {
    private String id;
    private int minute;
    private PlayerResponse player;
    private Boolean isOnGoal;
}
