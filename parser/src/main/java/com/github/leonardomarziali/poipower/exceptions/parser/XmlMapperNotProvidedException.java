package com.github.leonardomarziali.poipower.exceptions.parser;

public class XmlMapperNotProvidedException extends ParseStartException{

    public XmlMapperNotProvidedException() {
        super("XmlMapper not provided. Probably the call to setXmlMapper method is missing");
    }
}
