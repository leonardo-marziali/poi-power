package com.leomarzia.poipower.exception.reflection;

public class FieldNotFoundException extends RuntimeException{

    public FieldNotFoundException(String fieldName, Class<?> clazz){
        super(String.format("Field %s not found in %s class", fieldName, clazz.getName()));
    }
}
