package com.leomarzia.poipower;

import com.leomarzia.poipower.api.tags.Mapper;
import com.leomarzia.poipower.exception.file.FileNotProvidedException;
import com.leomarzia.poipower.exception.jaxb.JaxbUnmarshallException;
import com.leomarzia.poipower.exception.parser.ObjectsOrListsToSetPerSheetKeyException;
import com.leomarzia.poipower.singleton.JaxbContextInstance;
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


//    public void parse() {
//        for (var objectOrListToSetPerSheet : this.objectsOrListsToSetPerSheet.entrySet()) {
//
//        }
//    }

}
