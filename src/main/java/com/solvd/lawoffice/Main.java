package com.solvd.lawoffice;

import com.solvd.lawoffice.binary.*;
import com.solvd.lawoffice.dao.mybatis.*;
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

        ClientImpl clientMyBatis = new ClientImpl();
        ClientServiceImpl clientService = new ClientServiceImpl();
        BillDetailsServiceImpl billDetailsService = new BillDetailsServiceImpl();
        JudgeServiceImpl judgeService = new JudgeServiceImpl();
        CaseFiledServiceImpl caseFiledService = new CaseFiledServiceImpl();
        LawFirmServiceImpl lawFirmService = new LawFirmServiceImpl();
        AttorneyServiceImpl attorneyService = new AttorneyServiceImpl();
        LawFirmAwardServiceImpl lawFirmAwardService = new LawFirmAwardServiceImpl();
        AttorneyAssociationBarServiceImpl attorneyAssociationBarService = new AttorneyAssociationBarServiceImpl();
        AssociationBarServiceImpl associationBarService = new AssociationBarServiceImpl();

        /* ASSOCIATION BAR - HARD CODED VALUES MYBatis & Jdbc */
        logger.info("Inserting data into Association_Bars Table");
        for (AssociationBar associationBar : data.associationBarCreation()) {
//            associationBarMyBatis.insert(associationBar);
            associationBarService.insert(associationBar);
        }

        logger.info("Deleting 1 Association bar from Association bar table as well as attorney Association bar table");
//        associationBarMyBatis.deleteByAssociationBarId(101);
        associationBarService.deleteById(101);

        /*LAWFIRM - Using MyBatis Inserting Class objects into DB*/
//        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
//        for (LawFirm lawFirm : data.lawFirmMyBatisData()) {
//            lawFirmMyBatis.insert(lawFirm);
//            for (Attorney attorney : lawFirm.getAttorneyList()) {
//                attorneyMyBatis.insert(attorney, lawFirm.getLawFirmId());
//                for (Integer associationBarId : attorney.getAssociationBarIdList()) {
//                    attorneyAssociationBarMyBatis.insert(associationBarId, attorney.getAttorneyId());
//                }
//            }
//        }
        /*LAWFIRM - Using JDBC Inserting class Objects into DB*/
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        for (LawFirm lawFirm : data.lawFirmJdbcData()) {
//            logger.info(lawFirm.getLawFirmId());
            lawFirmService.insert(lawFirm);
        }

        /*Find By ID -- Using Jdbc Finding a record*/
        logger.info("Finding Attorney by ID");
        Optional<Attorney> attorneyListJdbc = attorneyService.findById(1001);
        if (attorneyListJdbc.isPresent()) {
            ArrayList<Attorney> newList = (ArrayList<Attorney>) attorneyListJdbc.stream().collect(Collectors.toList());
            for (Attorney attorney : newList) {
                logger.info("Id: " + attorney.getAttorneyId());
                logger.info("Name: " + attorney.getAttorneyName());
                logger.info("country: " + attorney.getCountry());
                logger.info("city: " + attorney.getCity());
                logger.info("LawFirm: " + attorney.getLawFirmId());
            }
        }

//        /*Find By ID -- Using Jdbc Finding a record*/
//        logger.info("Finding Attorney by ID");
//        Optional<Attorney> attorneyListMyBatis = attorneyMyBatis.findById(1005);
//        if (attorneyListMyBatis.isPresent()) {
//            ArrayList<Attorney> attorneyListById = (ArrayList<Attorney>) attorneyListMyBatis
//                    .stream().collect(Collectors.toList());
//            for (Attorney attorney : attorneyListById) {
//                logger.info("Id: " + attorney.getAttorneyId());
//                logger.info("Name: " + attorney.getAttorneyName());
//                logger.info("country: " + attorney.getCountry());
//                logger.info("city: " + attorney.getCity());
//                logger.info("LawFirm: " + attorney.getLawFirmId());
//            }
//        }
        /*Find attorney By Name JDBC*/
        logger.info("Finding Attorney by attorneyName");
        Optional<Attorney> attorneyListMyBatisFindByName = attorneyService.findByName("Lakshmi");
        if (attorneyListMyBatisFindByName.isPresent()) {
            ArrayList<Attorney> attorneyListById = (ArrayList<Attorney>) attorneyListMyBatisFindByName
                    .stream().collect(Collectors.toList());
            for (Attorney attorney : attorneyListById) {
                logger.info("Id: " + attorney.getAttorneyId());
                logger.info("Name: " + attorney.getAttorneyName());
                logger.info("country: " + attorney.getCountry());
                logger.info("city: " + attorney.getCity());
                logger.info("LawFirm: " + attorney.getLawFirmId());
            }
        }

        /*Area OF Practice Using MyBatis loading into Db*/
        AreaOfPracticeService areaOfPracticeService = new AreaOfPracticeServiceImpl();
        logger.info("Adding Attorney Area of practices");
        for (AreaOfPractice areaOfPractice : data.AreaOfPracticesMyBatis()) {
            areaOfPracticeService.insert(areaOfPractice);
        }
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
//        /*DOM PARSER using JDBC*/
//        DomParser domParserJdbc = new DomParser();
//        domParserJdbc.initializer("src/main/resources/dom/lawfirmDomjdbc.xml");
//        courtList = domParserJdbc.courtParser(); //Converting XML file to class Objects
//        CourtServiceImpl courtJdbc = new CourtServiceImpl();
//        for (Court court : courtList) {
//            Judge judge = court.getJudge();
//            judgeJdbc.insert(judge);
//            courtJdbc.insert(court, judge.getJudgeId());
//            ArrayList<CaseFiled> caseFiledList = court.getCaseFiledList();
//            for (CaseFiled caseFiled : caseFiledList) {
//                caseFiledJdbc.insert(caseFiled, caseFiled.getClientId());
//            }
//        }
        /*JAXB Parser*/
        File file = new File("src/main/resources/jaxb/lawfirmjaxb.xml");
        JaxbParser jaxbParser = new JaxbParser();
        LawFirm lawFirm = jaxbParser.readingXmlJaxb(file);
        /*Using JDBC Implementation loading class objects into DB*/
        lawFirmService.insert(lawFirm);
        for (Award award : lawFirm.getAwardList()) {
            logger.info(award.getAwardId() + "  " + lawFirm.getLawFirmId());
            lawFirmAwardService.insert(award, lawFirm.getLawFirmId());
        }
        /*Jackson Parser*/
        JacksonParser jacksonParser = new JacksonParser();
        List<Client> clients = jacksonParser.readXmlFile(new File("src/main/resources/jackson/clientjackson.json"));
        /*Using MyBatis loading class objects into DB*/
        for (Client client : clients) {
            clientMyBatis.insert(client);
            for (CaseFiled caseFiled : client.getCaseFiledList()) {
                caseFiledService.insert(caseFiled, client.getClientId());
            }
            for (BillDetails billDetails : client.getBillDetailList()) {
                billDetailsService.insert(billDetails, client.getClientId());
            }
        }
//        clients = jacksonParser.readXmlFile(new File("src/main/resources/jackson/clientjacksonJdbc.json"));
//        /*Using MyBatis loading class objects into DB*/
//        for (Client client : clients) {
//            clientService.insert(client);
//        }
        /*Writing class Objects into Json File*/
        jacksonParser.writeXmlFile(clients);
    }
}
