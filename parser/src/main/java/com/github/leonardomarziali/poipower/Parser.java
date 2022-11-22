package com.github.leonardomarziali.poipower;

import com.github.leonardomarziali.poipower.exceptions.file.XmlNotProvidedException;
import com.github.leonardomarziali.poipower.exceptions.jaxb.JaxbUnmarshallException;
import com.github.leonardomarziali.poipower.exceptions.parser.ObjToSetNotFoundException;
import com.github.leonardomarziali.poipower.exceptions.parser.WorkbookNotProvidedException;
import com.github.leonardomarziali.poipower.objtoset.props.ObjToSetProps;
import com.github.leonardomarziali.poipower.processors.ParserProcessor;
import com.github.leonardomarziali.poipower.processors.Processor;
import com.github.leonardomarziali.poipower.singleton.JaxbContextInstance;
import com.leomarzia.poipower.api.tags.ParserTag;
import jakarta.xml.bind.JAXBException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.File;
import java.util.Map;

import static com.github.leonardomarziali.poipower.exceptions.parser.ObjToSetNotFoundException.ObjToSetNotFoundExceptionCases.EMPTY;
import static com.github.leonardomarziali.poipower.exceptions.parser.ObjToSetNotFoundException.ObjToSetNotFoundExceptionCases.NULL;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@Getter
@SuppressWarnings("unused")
public class Parser {

    Workbook workbookToParse;

    @Getter(AccessLevel.NONE)
    File xmlMapper;

    @Getter(AccessLevel.NONE)
    ParserTag parserTag;

    Map<String, ObjToSetProps> objToSet;

    public void setWorkbookToParse(Workbook workbookToParse) {
        if (workbookToParse == null) {
            throw new WorkbookNotProvidedException();
        } else {
            this.workbookToParse = workbookToParse;
        }
    }

    public void setXmlMapper(File xmlMapper) {
        unmarshalXmlMapper(xmlMapper);
        this.xmlMapper = xmlMapper;
    }

    public void setObjToSet(Map<String, ObjToSetProps> objToSet) {
        if (objToSet == null) {
            throw new ObjToSetNotFoundException(NULL);
        } else if (objToSet.isEmpty()) {
            throw new ObjToSetNotFoundException(EMPTY);
        } else {
            this.objToSet = objToSet;
        }
    }

    private void unmarshalXmlMapper(File xmlMapper) {
        // TODO: Add other file exception cases
        if (xmlMapper == null) {
            throw new XmlNotProvidedException();
        }
        try {
            // TODO: Add validation against xsd before unmarshall
            this.parserTag = (ParserTag) JaxbContextInstance.getInstance().getUnmarshaller().unmarshal(xmlMapper);
        } catch (JAXBException e) {
            throw new JaxbUnmarshallException(xmlMapper);
        }
    }

    public void parse() {
        checkIfAllElementsHaveBeenSetForParse();
        Processor parserProcessor = new ParserProcessor(parserTag);
        parserProcessor.process();
    }

    private void checkIfAllElementsHaveBeenSetForParse() {
        if (workbookToParse == null) {
            throw new WorkbookNotProvidedException();
        } else if (xmlMapper == null) {
            throw new XmlNotProvidedException();
        } else if (objToSet == null) {
            throw new ObjToSetNotFoundException(NULL);
        } else if (objToSet.isEmpty()) {
            throw new ObjToSetNotFoundException(EMPTY);
        }
    }
}
