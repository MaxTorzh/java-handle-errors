package ru.yandex.practicum.exceptions;

public class HappinessOverflowException extends RuntimeException {
    private final Integer happinessLevel;

    public HappinessOverflowException(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public int getHappinessLevel() {
        return happinessLevel;
    }
}
