package com.solvd.law_office;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.solvd.law_office.bin.*;
import com.solvd.law_office.service.CourtService;
import com.solvd.law_office.service.impl.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DataGenerator data = new DataGenerator();
        LawFirmServiceImpl lawFirmService = new LawFirmServiceImpl();
        AttorneyServiceImpl attorneyService = new AttorneyServiceImpl();
        AwardServiceImpl awardService = new AwardServiceImpl();
        LawFirmAwardServiceImpl lawFirmAwardService = new LawFirmAwardServiceImpl();
        AttorneyAssociationBarServiceImpl attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
        AssociationBarServiceImpl associationBarService = new AssociationBarServiceImpl();
        AreaOfPracticeServiceImpl areaOfPracticesService = new AreaOfPracticeServiceImpl();
//        logger.info("Inserting data into Association_Bars Table");
//        for (AssociationBar associationBar : data.associationBarCreation()) {
//            associationBarService.insert(associationBar);
//        }
//        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
//        for (LawFirm lawFirm : data.lawFirmCreation()) {
//            lawFirmService.insert(lawFirm);
//        }
//        logger.info("Finding Attorney by ID");
//        Optional<Attorney> attorneyList = attorneyService.findById(1001);
//        if (attorneyList.isPresent()) {
//            ArrayList<Attorney> newList = (ArrayList<Attorney>) attorneyList.stream().collect(Collectors.toList());
//            for (Attorney attorney : newList) {
//                logger.info("Name: " + attorney.getAttorneyName());
//                logger.info("Id: " + attorney.getAttorneyId());
//                logger.info("country: " + attorney.getCountry());
//                logger.info("city: " + attorney.getCity());
//                logger.info("LawFirm: " + attorney.getLawFirmId());
//            }
//        }
//        logger.info("Finding Attorney By country Name");
//        ArrayList<Attorney> attorneyList1 = attorneyService.findByCountry("USA");
//        if (attorneyList1 != null) {
//            for (Attorney attorney : attorneyList1) {
//                logger.info("Name: " + attorney.getAttorneyName());
//                logger.info("country: " + attorney.getCountry());
//            }
//        }
//        logger.info("Adding Attorney Area of practices");
//        for (AreaOfPractice areaOfPractice : data.AreaOfPractices()) {
//            areaOfPracticesService.insert(areaOfPractice);
//        }
//        logger.info("Deleting 1 Association bar from Association bar table as well as attorney Association bar table");
//        associationBarService.deleteById(101);
//        logger.info("Updating Attorney city");
//        attorneyService.updateCityById(1000, "Dayton");
//        logger.info("Adding Association Bar to an attorney");
//        attorneyAssociationBarService.addAssociationBar(1000, 102);
//
//        DomParser domParser = new DomParser();
//        domParser.initializer("src/main/resources/lawfirmDom.xml");
//        ArrayList<Court> courtList;
//        courtList = domParser.courtParser();
//        JudgeServiceImpl judgeService = new JudgeServiceImpl();
//        CaseServiceImpl caseService = new CaseServiceImpl();
//        CourtService courtService = new CourtServiceImpl();
//        for (Court court : courtList) {
//            Judge judge = court.getJudge();
//            judgeService.insert(judge);
//            courtService.insert(court, judge.getJudgeId());
//            ArrayList<CaseFiled> caseFiledList = court.getCaseFiledList();
//            for (CaseFiled caseFiled : caseFiledList) {
//                caseService.insert(caseFiled);
//            }
//
//        }
//        File file = new File("src/main/resources/lawfirmjaxb.xml");
//        JaxbParser jaxbParser = new JaxbParser();
//        LawFirm lawFirm = jaxbParser.readingXmlJaxb(file);
//        lawFirmService.insert(lawFirm);
//        for(Award award : lawFirm.getAwardList()){
//            lawFirmAwardService.insert(award,lawFirm.getLawFirmId());
//        }


        File file = new File("src/main/resources/clientjackson.json");
        ObjectMapper mapper = new ObjectMapper();
        try {

            Client client = mapper.readValue(file, Client.class);
            logger.info(client.getClientId());
//            for(Client client : clients.getClients()){
//                logger.info(client.getClientId());
//            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
