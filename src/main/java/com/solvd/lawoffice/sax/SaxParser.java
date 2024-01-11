package com.solvd.lawoffice.sax;

import com.solvd.lawoffice.db.Main;
import com.solvd.lawoffice.db.bin.Court;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SaxParser {
    private static final Logger logger = LogManager.getLogger(Main.class);



    public void readXmlFile(File file) {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = saxParserFactory.newSAXParser();
            CourtMyHandler courtMyHandler = new CourtMyHandler();

            parser.parse(file,courtMyHandler);
            ArrayList<Court> result = courtMyHandler.getCourts();
            for(Court court: result){
                logger.info(court.getCourtId());

            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
