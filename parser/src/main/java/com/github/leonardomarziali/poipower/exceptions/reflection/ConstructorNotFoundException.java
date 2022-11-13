package com.github.leonardomarziali.poipower.exceptions.reflection;

public class ConstructorNotFoundException extends RuntimeException {

    public ConstructorNotFoundException(Class<?> clazz) {
        super(String.format("Constructor not found in %s class", clazz.getName()));
    }
}
