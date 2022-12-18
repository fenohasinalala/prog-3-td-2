package com.hei.prog3td2.model.validation;

import com.hei.prog3td2.exception.BadRequestException;
import com.hei.prog3td2.model.Player;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PlayerValidator implements Consumer<Player> {
    private final Validator validator;

    public void accept(List<Player> players) {
        players.forEach(this::accept);
    }

    @Override public void accept(Player player) {
        Set<ConstraintViolation<Player>> violations = validator.validate(player);
        if (!violations.isEmpty()) {
            String constraintMessages = violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(". "));
            throw new BadRequestException(constraintMessages);
        }
    }
}
