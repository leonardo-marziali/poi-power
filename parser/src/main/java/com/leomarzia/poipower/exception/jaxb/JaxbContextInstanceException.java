package com.leomarzia.poipower.exception.jaxb;

public class JaxbContextInstanceException extends RuntimeException {

    public JaxbContextInstanceException() {
        super("An error occurred during JAXB context initialization");
    }
}
