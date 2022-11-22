package com.github.leonardomarziali.poipower.processors;

import com.github.leonardomarziali.poipower.Parser;
import com.github.leonardomarziali.poipower.exceptions.xmlmapper.ProvidedSheetIndexNotFoundInXmlMapper;
import com.github.leonardomarziali.poipower.exceptions.xmlmapper.ProvidedSheetNameNotFoundInXmlMapper;
import com.leomarzia.poipower.api.tags.ParserTag;
import com.leomarzia.poipower.api.tags.SheetIndexTag;
import com.leomarzia.poipower.api.tags.SheetNameTag;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class ParserProcessor extends Parser implements Processor {

    ParserTag parserTag;

    public void process() {

    }

    private SheetIndexTag getSheetByIndexTagByIndex(int index) {
        return parserTag.getSheetIndex()
                        .stream()
                        .filter(sheetByIndex -> sheetByIndex.getIndex() == index)
                        .findFirst()
                        .orElseThrow(() -> new ProvidedSheetIndexNotFoundInXmlMapper(index));
    }

    private SheetNameTag getSheetByNameTagByName(String name) {
        return parserTag.getSheetName()
                        .stream()
                        .filter(sheetByIndex -> sheetByIndex.getName().equals(name))
                        .findFirst()
                        .orElseThrow(() -> new ProvidedSheetNameNotFoundInXmlMapper(name));
    }
}
