package com.github.leonardomarziali.poipower.exceptions.parser;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParseStartException extends RuntimeException {

    public ParseStartException(String cause) {
        super(String.format("An error occurred while invoking the parse method -> %s", cause));
    }
}
