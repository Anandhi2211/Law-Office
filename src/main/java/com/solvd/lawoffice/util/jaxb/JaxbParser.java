package com.solvd.lawoffice.util.jaxb;

import com.solvd.lawoffice.binary.LawFirm;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class JaxbParser {
    private static final Logger logger = LogManager.getLogger(JaxbParser.class);

    public LawFirm readingXmlJaxb(File file) {
        LawFirm lawFirm;
        try {
            JAXBContext context = JAXBContext.newInstance(LawFirm.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            lawFirm = (LawFirm) unmarshaller.unmarshal(file);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
        return lawFirm;
    }
}
