package com.github.leonardomarziali.poipower.exceptions.reflection;

public class FieldNotFoundException extends RuntimeException{

    public FieldNotFoundException(String fieldName, Class<?> clazz){
        super(String.format("Field %s not found in %s class", fieldName, clazz.getName()));
    }
}
