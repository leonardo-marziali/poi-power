package com.github.leonardomarziali.poipower.exceptions.jaxb;

import java.io.File;

public class JaxbUnmarshallException extends RuntimeException {

    public JaxbUnmarshallException(File file) {
        super(String.format("An error has occurred during %s unmarshalling operation", file.getName()));
    }
}
