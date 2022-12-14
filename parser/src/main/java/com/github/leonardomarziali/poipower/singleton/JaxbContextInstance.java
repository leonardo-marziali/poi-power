package com.github.leonardomarziali.poipower.singleton;

import com.github.leonardomarziali.poipower.exceptions.jaxb.JaxbContextInstanceException;
import com.leomarzia.poipower.api.tags.ParserTag;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
public class JaxbContextInstance {

    static JaxbContextInstance instance = null;
    final JAXBContext jaxbContext;
    final Unmarshaller unmarshaller;

    private JaxbContextInstance() {
        try {
            this.jaxbContext = JAXBContext.newInstance(ParserTag.class);
            this.unmarshaller = this.jaxbContext.createUnmarshaller();
        } catch (JAXBException e) {
            e.printStackTrace();
            throw new JaxbContextInstanceException();
        }
    }

    public static JaxbContextInstance getInstance() {
        if (instance == null) instance = new JaxbContextInstance();

        return instance;
    }
}
