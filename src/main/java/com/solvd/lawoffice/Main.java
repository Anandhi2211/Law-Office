package com.solvd.lawoffice;

import com.solvd.lawoffice.binary.Attorney;
import com.solvd.lawoffice.binary.Client;
import com.solvd.lawoffice.binary.Court;
import com.solvd.lawoffice.binary.LawFirm;
import com.solvd.lawoffice.service.AreaOfPracticeService;
import com.solvd.lawoffice.service.impl.*;
import com.solvd.lawoffice.util.dom.DomParser;
import com.solvd.lawoffice.util.jackson.JacksonParser;
import com.solvd.lawoffice.util.jaxb.JaxbParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DataGenerator data = new DataGenerator();
        ClientServiceImpl clientService = new ClientServiceImpl();
        LawFirmServiceImpl lawFirmService = new LawFirmServiceImpl();
        AttorneyServiceImpl attorneyService = new AttorneyServiceImpl();
        /**
         * ASSOCIATION BAR
         * Insertion
         * Deletion
         */
        logger.info("Inserting data into Association_Bars Table");
        AssociationBarServiceImpl associationBarService = new AssociationBarServiceImpl();
        data.associationBarCreation()
                .stream().forEach(associationBar -> associationBarService.insert(associationBar));
        logger.info("Deletion from Association bar from Association bar table as well as attorney Association bar table");
        associationBarService.deleteByAssociationBarId(101);
        /*
         *LAWFIRM
         * Insertion
         */
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        data.lawFirmData()
                .stream()
                .forEach(lawFirm -> lawFirmService.insert(lawFirm));
        /**
         * Attorney
         * Finding by Id
         * Finding By Name
         * Deletion
         * Update
         */
        logger.info("Finding Attorney by ID");
        Optional<Attorney> attorneyList = attorneyService.findById(1001);
        if (attorneyList.isPresent()) {
            ArrayList<Attorney> newList = (ArrayList<Attorney>) attorneyList.stream()
                    .collect(Collectors.toList());
            for (Attorney attorney : newList) {
                logger.info("Id: " + attorney.getAttorneyId());
                logger.info("Name: " + attorney.getAttorneyName());
                logger.info("LawFirm: " + attorney.getLawFirmId());
            }
        }
        logger.info("Finding Attorney by attorneyName");
        attorneyList = attorneyService.findByName("Lakshmi");
        if (attorneyList.isPresent()) {
            ArrayList<Attorney> attorneyListById = (ArrayList<Attorney>) attorneyList.stream()
                    .collect(Collectors.toList());
            for (Attorney attorney : attorneyListById) {
                logger.info("Id: " + attorney.getAttorneyId());
                logger.info("Name: " + attorney.getAttorneyName());
                logger.info("LawFirm: " + attorney.getLawFirmId());
            }
        }
        logger.info("Adding Association Bar to an attorney");
        attorneyService.insertAttorneyAssociationBar(102, 1000);
        attorneyService.deleteAttorneyById(1000);
        logger.info("Updating Attorney city");
        attorneyService.updateCityById(1000, "Troy1");
        /**
         * Area OF Practice
         * Insertion
         * Deletion
         *
         */
        AreaOfPracticeService areaOfPracticeService = new AreaOfPracticeServiceImpl();
        logger.info("Deletion from AreaOfPractice from AreaOfPractice table as well as attorneyAreaOfPractice table");
        areaOfPracticeService.deleteByAreaOfPracticeId(1);
        logger.info("Adding Attorney Area of practices");
        data.AreaOfPractices()
                .stream()
                .forEach(areaOfPractice -> areaOfPracticeService.insert(areaOfPractice));
        /**
         * DOM PARSER
         * */
        DomParser domParserMybatis = new DomParser();
        domParserMybatis.initializer("src/main/resources/dom/lawfirmDom.xml");
        ArrayList<Court> courtList = domParserMybatis.courtParser(); //Converting XML file to class Objects
        CourtServiceImpl courtService = new CourtServiceImpl();
        courtList.stream().forEach(court -> courtService.insert(court, court.getJudge()));
        /**
         * JAXB Parser
         *
         *
         */
        File file = new File("src/main/resources/jaxb/lawfirmjaxb.xml");
        JaxbParser jaxbParser = new JaxbParser();
        LawFirm lawFirm = jaxbParser.readingXmlJaxb(file);
        lawFirmService.insert(lawFirm);
        /**
         * Jackson Parser
         * */
        JacksonParser jacksonParser = new JacksonParser();
        List<Client> clients = jacksonParser.readXmlFile(new File("src/main/resources/jackson/clientjackson.json"));
        clients.stream().forEach(client -> clientService.insert(client));
        jacksonParser.writeXmlFile(clients);
    }
}
