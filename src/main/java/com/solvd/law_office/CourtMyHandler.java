package com.solvd.law_office;

import com.solvd.law_office.bin.Court;
import com.solvd.law_office.bin.Judge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

public class CourtMyHandler extends DefaultHandler {
    private static final Logger logger = LogManager.getLogger(CourtMyHandler.class);
    private StringBuilder element;

//    boolean caseid = false;
    boolean country = false;
    boolean city = false;
    boolean judgestatus = false;

    public ArrayList<Court> getCourts() {
        return courts;
    }

    private ArrayList<Court> courts = new ArrayList<>();
    private Court court = new Court();
    private Judge judge = new Judge();


    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("court")){
            court.setCourtId(Integer.parseInt(attributes.getValue("id")));
        }
        else if(qName.equalsIgnoreCase("country")){
            court.setCountry(element.toString());
            country=true;
        }
        else if(qName.equalsIgnoreCase("city")){
            court.setCity(element.toString());
            city = true;
        }
        else if(qName.equalsIgnoreCase("judge")){
            judge.setJudgeId(Integer.parseInt(attributes.getValue("id")));
            judge.setJudgeName(attributes.getValue("name"));
            court.setJudge(judge);
            judgestatus = true;
        }
        courts.add(court);
    }


    @Override
    public void endElement(String uri, String localName, String qName ) throws SAXException {
        if(qName.equalsIgnoreCase("case")){
            logger.info("End of the Element: "+qName);
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (element == null) {
            element = new StringBuilder();
        } else {
            element.append(ch, start, length);
        }
    }
}

