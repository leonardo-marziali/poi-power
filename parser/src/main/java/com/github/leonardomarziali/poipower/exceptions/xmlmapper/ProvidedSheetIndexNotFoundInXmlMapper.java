package com.github.leonardomarziali.poipower.exceptions.xmlmapper;

public class ProvidedSheetIndexNotFoundInXmlMapper extends RuntimeException{

    public ProvidedSheetIndexNotFoundInXmlMapper(int providedIndex) {
        super(String.format("Provided sheet index %s not found in xml mapper", providedIndex));
    }
}
