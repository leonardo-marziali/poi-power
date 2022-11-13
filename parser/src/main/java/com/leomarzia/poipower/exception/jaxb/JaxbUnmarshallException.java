package com.leomarzia.poipower.exception.jaxb;

import java.io.File;

public class JaxbUnmarshallException extends RuntimeException {

    public JaxbUnmarshallException(File file) {
        super(String.format("An error occurred during %s unmarshalling operation", file.getName()));
    }
}
