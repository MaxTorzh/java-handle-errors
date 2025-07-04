package ru.yandex.practicum.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IncorrectCountException extends RuntimeException {
    public IncorrectCountException(String message) {
        super(message);
    }
}
