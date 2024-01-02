package com.solvd.law_office;

import com.solvd.law_office.bin.LawFirm;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class JaxbParser {
    public void initializer(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(LawFirm.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            LawFirm lawFirm = (LawFirm) unmarshaller.unmarshal(file);
            System.out.println();
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
