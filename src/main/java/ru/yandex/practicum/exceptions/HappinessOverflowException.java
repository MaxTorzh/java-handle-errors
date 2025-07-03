package ru.yandex.practicum.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HappinessOverflowException extends RuntimeException {
    private final Integer happinessLevel;

    public HappinessOverflowException(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }
}
