package com.github.leonardomarziali.poipower.tagprocessors;

import com.github.leonardomarziali.poipower.exceptions.xmlmapper.ProvidedSheetIndexNotFoundInXmlMapper;
import com.github.leonardomarziali.poipower.exceptions.xmlmapper.ProvidedSheetNameNotFoundInXmlMapper;
import com.leomarzia.poipower.api.tags.Mapper;
import com.leomarzia.poipower.api.tags.SheetByIndex;
import com.leomarzia.poipower.api.tags.SheetByName;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
public class MapperProcessor {

    Mapper mapperTag;

    public void process(Map<Integer, List<?>> getObjectsOrListsToSetPerSheetIndex,
                        Map<String, List<?>> getObjectsOrListsToSetPerSheetName,
                        Map<Object, List<?>> getObjectsOrListsToSetPerSheetIndexOrName) {

        if (getObjectsOrListsToSetPerSheetIndex != null) {
            getObjectsOrListsToSetPerSheetIndex.forEach((sheetIndex, objectToSet) -> {
                SheetByIndex sheetByIndex = getSheetByIndexTagByIndex(sheetIndex);
            });
        }

        if (getObjectsOrListsToSetPerSheetName != null) {
            getObjectsOrListsToSetPerSheetName.forEach((sheetIndex, objectToSet) -> {
                SheetByName sheetByIndex = getSheetByNameTagByName(sheetIndex);
            });
        }


    }

    private SheetByIndex getSheetByIndexTagByIndex(int index) {
        return mapperTag.getSheetByIndex()
                        .stream()
                        .filter(sheetByIndex -> sheetByIndex.getIndex() == index)
                        .findFirst()
                        .orElseThrow(() -> new ProvidedSheetIndexNotFoundInXmlMapper(index));
    }

    private SheetByName getSheetByNameTagByName(String name) {
        return mapperTag.getSheetByName()
                        .stream()
                        .filter(sheetByIndex -> sheetByIndex.getName().equals(name))
                        .findFirst()
                        .orElseThrow(() -> new ProvidedSheetNameNotFoundInXmlMapper(name));
    }
}
