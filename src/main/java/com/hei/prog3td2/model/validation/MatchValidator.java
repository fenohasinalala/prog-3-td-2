package com.hei.prog3td2.model.validation;

import com.hei.prog3td2.exception.BadRequestException;
import com.hei.prog3td2.model.Match;
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
public class MatchValidator implements Consumer<Match> {
    private final Validator validator;

    public void accept(List<Match> matchs) {
        matchs.forEach(this::accept);
    }

    @Override public void accept(Match match) {
        Set<ConstraintViolation<Match>> violations = validator.validate(match);
        if (!violations.isEmpty()) {
            String constraintMessages = violations
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(". "));
            throw new BadRequestException(constraintMessages);
        }
    }
}
