package com.github.leonardomarziali.poipower.exceptions.parser;

import static com.github.leonardomarziali.poipower.exceptions.parser.ObjToSetNotFoundException.ObjToSetNotFoundExceptionCases.NULL;

public class ObjToSetNotFoundException extends RuntimeException {

    public ObjToSetNotFoundException(ObjToSetNotFoundExceptionCases exceptionCase) {
        super(String.format("The map of objects to set is %s", exceptionCase == NULL ? "null" : "is empty"));
    }

    public enum ObjToSetNotFoundExceptionCases {
        NULL, EMPTY
    }
}
