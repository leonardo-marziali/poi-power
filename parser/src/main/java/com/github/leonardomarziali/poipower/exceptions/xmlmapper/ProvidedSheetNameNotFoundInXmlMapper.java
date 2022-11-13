package com.github.leonardomarziali.poipower.exceptions.xmlmapper;

public class ProvidedSheetNameNotFoundInXmlMapper extends RuntimeException {

    public ProvidedSheetNameNotFoundInXmlMapper(String providedName) {
        super(String.format("Provided sheet name %s not found in xml mapper", providedName));
    }
}
