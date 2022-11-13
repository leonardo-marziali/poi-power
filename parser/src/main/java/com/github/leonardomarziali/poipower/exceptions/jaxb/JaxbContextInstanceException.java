package com.github.leonardomarziali.poipower.exceptions.jaxb;

public class JaxbContextInstanceException extends RuntimeException {

    public JaxbContextInstanceException() {
        super("An error has occurred during JAXB context initialization");
    }
}
