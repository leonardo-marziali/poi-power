package com.github.leonardomarziali.poipower.exceptions.reflection;

public class MethodNotFoundException extends RuntimeException {

    public MethodNotFoundException(String methodName, Class<?> clazz) {
        super(String.format("Could not find method %s in %s class", methodName, clazz.getName()));
    }
}
