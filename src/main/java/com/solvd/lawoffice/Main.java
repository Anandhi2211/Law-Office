package com.solvd.lawoffice;

import com.solvd.lawoffice.binary.*;
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
        JudgeServiceImpl judgeService = new JudgeServiceImpl();
        CaseFiledServiceImpl caseFiledService = new CaseFiledServiceImpl();
        LawFirmServiceImpl lawFirmService = new LawFirmServiceImpl();
        AttorneyServiceImpl attorneyService = new AttorneyServiceImpl();
        LawFirmAwardServiceImpl lawFirmAwardService = new LawFirmAwardServiceImpl();
        AttorneyAssociationBarServiceImpl attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();

        /* ASSOCIATION BAR - HARD CODED VALUES MYBatis & Jdbc */
        logger.info("Inserting data into Association_Bars Table");
        AssociationBarServiceImpl associationBarService = new AssociationBarServiceImpl();

        data.associationBarCreation()
                .stream()
                .map(associationBar -> associationBarService.insert(associationBar));

        logger.info("Deletion from Association bar from Association bar table as well as attorney Association bar table");
        associationBarService.deleteById(101);

        /*LAWFIRM - Inserting class Objects into DB*/
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        data.lawFirmJdbcData()
                .stream()
                .map(lawFirm -> lawFirmService.insert(lawFirm));

        /*Find By ID -- Finding a record*/
        logger.info("Finding Attorney by ID");
        Optional<Attorney> attorneyListJdbc = attorneyService.findById(1001);

        if (attorneyListJdbc.isPresent()) {
            ArrayList<Attorney> newList = (ArrayList<Attorney>) attorneyListJdbc.stream().collect(Collectors.toList());
            for (Attorney attorney : newList) {
                logger.info("Id: " + attorney.getAttorneyId());
                logger.info("Name: " + attorney.getAttorneyName());
                logger.info("LawFirm: " + attorney.getLawFirmId());
            }
        }
        /*Find attorney By Name */
        logger.info("Finding Attorney by attorneyName");
        Optional<Attorney> attorneyListMyBatisFindByName = attorneyService.findByName("Lakshmi");
        if (attorneyListMyBatisFindByName.isPresent()) {
            ArrayList<Attorney> attorneyListById = (ArrayList<Attorney>) attorneyListMyBatisFindByName
                    .stream().collect(Collectors.toList());
            for (Attorney attorney : attorneyListById) {
                logger.info("Id: " + attorney.getAttorneyId());
                logger.info("Name: " + attorney.getAttorneyName());
                logger.info("LawFirm: " + attorney.getLawFirmId());
            }
        }
        /*Area OF Practice loading into Db*/
        AreaOfPracticeService areaOfPracticeService = new AreaOfPracticeServiceImpl();
        logger.info("Adding Attorney Area of practices");
        data.AreaOfPracticesMyBatis()
                .stream()
                .map(areaOfPractice -> areaOfPracticeService.insert(areaOfPractice));
//        for (AreaOfPractice areaOfPractice : data.AreaOfPracticesMyBatis()) {
//            areaOfPracticeService.insert(areaOfPractice);
//        }

        logger.info("Updating Attorney city");
        attorneyService.updateCityById(1000, "Troy");
        logger.info("Updating Attorney city");
        attorneyService.updateCityById(1000, "Harrisburg");

        logger.info("Adding Association Bar to an attorney");
        attorneyAssociationBarService.insert(102, 1000);

        /*DOM PARSER using MYBATIS*/
        DomParser domParserMybatis = new DomParser();
        domParserMybatis.initializer("src/main/resources/dom/lawfirmDom.xml");
        ArrayList<Court> courtList = domParserMybatis.courtParser(); //Converting XML file to class Objects
        CourtServiceImpl courtService = new CourtServiceImpl();

        for (Court court : courtList) {
            Judge judge = court.getJudge();
            judgeService.insert(judge);
            courtService.insert(court, judge.getJudgeId());
            ArrayList<CaseFiled> caseFiledList = court.getCaseFiledList();
            for (CaseFiled caseFiled : caseFiledList) {
                caseFiledService.insert(caseFiled, caseFiled.getClientId());
            }
        }
        /*JAXB Parser*/
        File file = new File("src/main/resources/jaxb/lawfirmjaxb.xml");
        JaxbParser jaxbParser = new JaxbParser();
        LawFirm lawFirm = jaxbParser.readingXmlJaxb(file);
        /* Implementation loading class objects into DB*/
        lawFirmService.insert(lawFirm);
        for (Award award : lawFirm.getAwardList()) {
            logger.info(award.getAwardId() + "  " + lawFirm.getLawFirmId());
            lawFirmAwardService.insert(award, lawFirm.getLawFirmId());
        }
        /*Jackson Parser*/
        JacksonParser jacksonParser = new JacksonParser();
        List<Client> clients = jacksonParser.readXmlFile(new File("src/main/resources/jackson/clientjackson.json"));
        /* loading class objects into DB*/
        for (Client client : clients) {
            clientService.insert(client);
        }
        /*Writing class Objects into Json File*/
        jacksonParser.writeXmlFile(clients);
    }
}
