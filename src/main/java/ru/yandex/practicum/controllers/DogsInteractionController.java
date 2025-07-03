package ru.yandex.practicum.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.exceptions.HappinessOverflowException;
import ru.yandex.practicum.exceptions.IncorrectCountException;
import ru.yandex.practicum.responses.ErrorResponse;

import java.util.Map;

@RestController
@RequestMapping("/dogs")
public class DogsInteractionController {
    private int happiness = 0;

    @GetMapping("/converse")
    public Map<String, String> converse() {
        checkHappiness();
        happiness += 2;
        return Map.of("talk", "Гав!");
    }

    @GetMapping("/pet")
    public Map<String, String> pet(@RequestParam(required = false) final Integer count) {
        if (count == null) {
            throw new IncorrectCountException("Параметр count равен null.");
        }
        if (count <= 0) {
            throw new IncorrectCountException("Параметр count имеет отрицательное значение.");
        }
        checkHappiness();
        happiness += count;
        return Map.of("action", "Вильнул хвостом. ".repeat(count));
    }

    @GetMapping("/happiness")
    public Map<String, Integer> happiness() {
        return Map.of("happiness", happiness);
    }

    @ExceptionHandler
    public ErrorResponse handleIncorrectCount(final IncorrectCountException e) {
        return new ErrorResponse(
                "Ошибка с параметром count.",
                e.getMessage());
    }

    @ExceptionHandler
    public ErrorResponse handleHappinessOverflow(final HappinessOverflowException e) {
        return new ErrorResponse(
                "Слишком большое значение [happiness]",
                "Осторожно, вы так избалуете пёсика! Уровень happiness: " + e.getHappinessLevel());

    }

    private void checkHappiness() {
        if (happiness >= 10) {
            throw new HappinessOverflowException(happiness);
        }
    }
}
