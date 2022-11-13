package com.github.leonardomarziali.poipower;

import com.github.leonardomarziali.poipower.exceptions.file.FileNotProvidedException;
import com.github.leonardomarziali.poipower.exceptions.jaxb.JaxbUnmarshallException;
import com.github.leonardomarziali.poipower.exceptions.parser.MapOfObjectsPerSheetToSetNotProvidedException;
import com.github.leonardomarziali.poipower.exceptions.parser.ObjectsOrListsToSetPerSheetKeyException;
import com.github.leonardomarziali.poipower.exceptions.parser.WorkbookNotProvidedException;
import com.github.leonardomarziali.poipower.exceptions.parser.XmlMapperNotProvidedException;
import com.github.leonardomarziali.poipower.singleton.JaxbContextInstance;
import com.github.leonardomarziali.poipower.tagprocessors.MapperProcessor;
import com.leomarzia.poipower.api.tags.Mapper;
import jakarta.xml.bind.JAXBException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.List;
import java.util.Map;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@Setter
//@SuppressWarnings("unused")
public class Parser {

    Workbook workbookToParse;

    @Setter(AccessLevel.NONE)
    File xmlMapper;

    @Setter(AccessLevel.NONE)
    Mapper mapper;

    public void setXmlMapper(File xmlMapper) {
        unmarshalXmlMapper(xmlMapper);
        this.xmlMapper = xmlMapper;
    }

    private void unmarshalXmlMapper(File xmlMapper) {
        // TODO: Add other file exception cases
        if (xmlMapper == null) {
            throw new FileNotProvidedException();
        }
        try {
            // TODO: Add validation against xsd before unmarshall
            this.mapper = (Mapper) JaxbContextInstance.getInstance().getUnmarshaller().unmarshal(xmlMapper);
        } catch (JAXBException e) {
            throw new JaxbUnmarshallException(xmlMapper);
        }
    }

    Map<Integer, List<?>> objectsOrListsToSetPerSheetIndex;

    Map<String, List<?>> objectsOrListsToSetPerSheetName;

    @Setter(AccessLevel.NONE)
    Map<Object, List<?>> objectsOrListsToSetPerSheetIndexOrName;

    public void setObjectsOrListsToSetPerSheetIndexOrName(Map<Object, List<?>> objectsOrListsToSetPerSheetIndexOrName) {
        validateObjectsOrListsToSetPerSheet(objectsOrListsToSetPerSheetIndexOrName);
        this.objectsOrListsToSetPerSheetIndexOrName = objectsOrListsToSetPerSheetIndexOrName;
    }

    private void validateObjectsOrListsToSetPerSheet(Map<Object, List<?>> objectsOrListsToSetPerSheet) {
        objectsOrListsToSetPerSheet.forEach((key, value) -> {
            if (!(key instanceof String || key instanceof Integer)) {
                throw new ObjectsOrListsToSetPerSheetKeyException(key);
            }

            // TODO: Add validation for value which cannot be primitive
        });
    }

    public void parse() {
        checkIfAllElementsHaveBeenSetForParse();
        MapperProcessor mapperProcessor = new MapperProcessor(mapper);
        mapperProcessor.process(getObjectsOrListsToSetPerSheetIndex(),
                                getObjectsOrListsToSetPerSheetName(),
                                getObjectsOrListsToSetPerSheetIndexOrName());
    }

    private void checkIfAllElementsHaveBeenSetForParse() {
        if (workbookToParse == null) {
            throw new WorkbookNotProvidedException();
        } else if (xmlMapper == null) {
            throw new XmlMapperNotProvidedException();
        } else if (objectsOrListsToSetPerSheetIndex == null && objectsOrListsToSetPerSheetName == null &&
                   objectsOrListsToSetPerSheetIndexOrName == null) {
            throw new MapOfObjectsPerSheetToSetNotProvidedException();
        }
    }
}
