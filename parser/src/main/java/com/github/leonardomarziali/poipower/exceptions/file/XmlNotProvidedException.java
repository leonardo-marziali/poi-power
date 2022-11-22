package com.github.leonardomarziali.poipower.exceptions.file;

public class XmlNotProvidedException extends RuntimeException{

    public XmlNotProvidedException() {
        super("The provided file is null");
    }
}
