package com.solvd.lawoffice.db;

import com.solvd.lawoffice.DataGenerator;
import com.solvd.lawoffice.db.binary.*;
import com.solvd.lawoffice.db.service.jdbc.*;
import com.solvd.lawoffice.db.service.mybatis.*;
import com.solvd.lawoffice.dom.DomParser;
import com.solvd.lawoffice.jackson.JacksonParser;
import com.solvd.lawoffice.jaxb.JaxbParser;
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
        ClientMyBatisImpl clientMyBatis = new ClientMyBatisImpl();
        ClientJdbcImpl clientJdbc = new ClientJdbcImpl();

        BillDetailsMyBatisImpl billDetailsMyBatis = new BillDetailsMyBatisImpl();
        JudgeMyBatisImpl judgeMyBatis = new JudgeMyBatisImpl();
        JudgeServiceImpl judgeJdbc = new JudgeServiceImpl();
        CaseFiledMyBatisImpl caseFiledMyBatis = new CaseFiledMyBatisImpl();
        CaseFiledJdbcImpl caseFiledJdbc = new CaseFiledJdbcImpl();

        CourtMyBatisImpl courtMyBatis = new CourtMyBatisImpl();
        CourtJdbcImpl courtJdbc = new CourtJdbcImpl();
        LawFirmJdbcImpl lawFirmJdbc = new LawFirmJdbcImpl();
        LawFirmMyBatisImpl lawFirmMyBatis = new LawFirmMyBatisImpl();
        AttorneyMyBatisImpl attorneyMyBatis = new AttorneyMyBatisImpl();
        AttorneyJdbcImpl attorneyJdbc = new AttorneyJdbcImpl();
        LawFirmAwardServiceImpl lawFirmAwardService = new LawFirmAwardServiceImpl();
        AttorneyAssociationBarMyBatisImpl attorneyAssociationBarMyBatis = new AttorneyAssociationBarMyBatisImpl();
        AttorneyAssociationBarJdbcImpl attorneyAssociationBarJdbc = new AttorneyAssociationBarJdbcImpl();
        AssociationBarMyBatisImpl associationBarMyBatis = new AssociationBarMyBatisImpl();
        AssociationBarJdbcImpl associationBarJdbc = new AssociationBarJdbcImpl();


        /*ASSOCIATION BAR - HARD CODED VALUES MYBatis & Jdbc*/
        logger.info("Inserting data into Association_Bars Table");
        for (AssociationBar associationBar : data.associationBarCreation()) {
            associationBarMyBatis.insert(associationBar);
//            associationBarJdbc.insert(associationBar);
        }
        logger.info("Deleting 1 Association bar from Association bar table as well as attorney Association bar table");
        associationBarMyBatis.deleteByAssociationBarId(101);
//        associationBarJdbc.deleteById(101);

        /*LAWFIRM - Using MyBatis Inserting Class objects into DB*/
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        for (LawFirm lawFirm : data.lawFirmMyBatisData()) {
            lawFirmMyBatis.insert(lawFirm);
            for (Attorney attorney : lawFirm.getAttorneyList()) {
                attorneyMyBatis.insert(attorney, lawFirm.getLawFirmId());
                for (Integer associationBarId : attorney.getAssociationBarIdList()) {
                    attorneyAssociationBarMyBatis.insert(associationBarId, attorney.getAttorneyId());
                }
            }
        }
        /*LAWFIRM - Using JDBC Inserting class Objects into DB*/
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        for (LawFirm lawFirm : data.lawFirmJdbcData()) {
//            logger.info(lawFirm.getLawFirmId());
            lawFirmJdbc.insert(lawFirm);
        }

        /*Find By ID -- Using Jdbc Finding a record*/
        logger.info("Finding Attorney by ID");
        Optional<Attorney> attorneyListJdbc = attorneyJdbc.findById(1001);
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

        /*Find By ID -- Using Jdbc Finding a record*/
        logger.info("Finding Attorney by ID");
        Optional<Attorney> attorneyListMyBatis = attorneyMyBatis.findById(1005);
        if (attorneyListMyBatis.isPresent()) {
            ArrayList<Attorney> attorneyListById = (ArrayList<Attorney>) attorneyListMyBatis
                    .stream().collect(Collectors.toList());
            for (Attorney attorney : attorneyListById) {
                logger.info("Id: " + attorney.getAttorneyId());
                logger.info("Name: " + attorney.getAttorneyName());
                logger.info("country: " + attorney.getCountry());
                logger.info("city: " + attorney.getCity());
                logger.info("LawFirm: " + attorney.getLawFirmId());
            }
        }
        /*Find attorney By Name JDBC*/
        logger.info("Finding Attorney by attorneyName");
        Optional<Attorney> attorneyListMyBatisFindByName = attorneyMyBatis.findByName("Lakshmi");
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
        AreaOfPracticeMyBatis areaOfPracticeMyBatis = new AreaOfPracticeMyBatis();
        logger.info("Adding Attorney Area of practices");
        for (AreaOfPractice areaOfPractice : data.AreaOfPracticesMyBatis()) {
            areaOfPracticeMyBatis.insert(areaOfPractice);
        }
        logger.info("Updating Attorney city");
        attorneyJdbc.updateCityById(1000, "Troy");
        logger.info("Updating Attorney city");
        attorneyMyBatis.updateCityById(1000, "Harrisburg");

        logger.info("Adding Association Bar to an attorney");
        attorneyAssociationBarJdbc.insert(1000, 102);

        /*DOM PARSER using MYBATIS*/
        DomParser domParserMybatis = new DomParser();
        domParserMybatis.initializer("src/main/resources/dom/lawfirmDom.xml");
        ArrayList<Court> courtList = domParserMybatis.courtParser(); //Converting XML file to class Objects
        for (Court court : courtList) {
            Judge judge = court.getJudge();
            judgeMyBatis.insert(judge);
            courtMyBatis.insert(court, judge.getJudgeId());
            ArrayList<CaseFiled> caseFiledList = court.getCaseFiledList();
            for (CaseFiled caseFiled : caseFiledList) {
                caseFiledMyBatis.insert(caseFiled, caseFiled.getClientId());
            }
        }

        /*DOM PARSER using JDBC*/
        DomParser domParserJdbc = new DomParser();
        domParserJdbc.initializer("src/main/resources/dom/lawfirmDomjdbc.xml");
        courtList = domParserJdbc.courtParser(); //Converting XML file to class Objects
        for (Court court : courtList) {
            Judge judge = court.getJudge();
            judgeJdbc.insert(judge);
            courtJdbc.insert(court, judge.getJudgeId());
            ArrayList<CaseFiled> caseFiledList = court.getCaseFiledList();
            for (CaseFiled caseFiled : caseFiledList) {
                caseFiledJdbc.insert(caseFiled, caseFiled.getClientId());
            }
        }

////        SaxParser saxParser = new SaxParser();
////        File file = new File("src/main/resources/lawfirmDom.xml");
////        saxParser.readXmlFile(file);
//
        /*JAXB Parser*/
        File file = new File("src/main/resources/jaxb/lawfirmjaxb.xml");
        JaxbParser jaxbParser = new JaxbParser();
        LawFirm lawFirm = jaxbParser.readingXmlJaxb(file);
        /*Using JDBC Implementation loading class objects into DB*/
        lawFirmJdbc.insert(lawFirm);
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
                caseFiledMyBatis.insert(caseFiled, client.getClientId());
            }
            for (BillDetails billDetails : client.getBillDetailList()) {
                billDetailsMyBatis.insert(billDetails, client.getClientId());
            }
        }

//        clients = jacksonParser.readXmlFile(new File("src/main/resources/jackson/clientjacksonJdbc.json"));
//        /*Using MyBatis loading class objects into DB*/
//        for (Client client : clients) {
//            clientJdbc.insert(client);
//        }
        /*Writing class Objects into Json File*/
        jacksonParser.writeXmlFile(clients);
    }
}
