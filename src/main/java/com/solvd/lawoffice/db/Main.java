package com.solvd.lawoffice.db;

import com.solvd.lawoffice.DataGenerator;
import com.solvd.lawoffice.db.bin.*;
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

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DataGenerator data = new DataGenerator();
        ClientMyBatisImpl clientMyBatis = new ClientMyBatisImpl();
        BillDetailsMyBatisImpl billDetailsMyBatis = new BillDetailsMyBatisImpl();
        JudgeMyBatisImpl judgeMyBatis = new JudgeMyBatisImpl();
        CaseFiledMyBatisImpl caseFiledMyBatis = new CaseFiledMyBatisImpl();
        CourtMyBatisImpl courtMyBatis = new CourtMyBatisImpl();
        LawFirmJdbcImpl lawFirmJdbc = new LawFirmJdbcImpl();
        LawFirmMyBatisImpl lawFirmMyBatis = new LawFirmMyBatisImpl();
        AttorneyMyBatisImpl attorneyMyBatis = new AttorneyMyBatisImpl();
        AttorneyJdbcImpl attorneyJdbc = new AttorneyJdbcImpl();
        LawFirmAwardServiceImpl lawFirmAwardService = new LawFirmAwardServiceImpl();
        AttorneyAssociationBarMyBatisImpl attorneyAssociationBarMyBatis = new AttorneyAssociationBarMyBatisImpl();
        AttorneyAssociationBarJdbcImpl attorneyAssociationBarJdbc = new AttorneyAssociationBarJdbcImpl();
        AssociationBarMyBatisImpl associationBarMyBatis = new AssociationBarMyBatisImpl();
        AssociationBarJdbcImpl associationBarJdbc = new AssociationBarJdbcImpl();

        /*HARD CODED VALUES MYBatis & Jdbc*/
        logger.info("Inserting data into Association_Bars Table");
        for (AssociationBar associationBar : data.associationBarCreation()) {
            associationBarMyBatis.insert(associationBar);
//            associationBarJdbc.insert(associationBar);
        }
        logger.info("Deleting 1 Association bar from Association bar table as well as attorney Association bar table");
        associationBarMyBatis.deleteByAssociationBarId(101);
//        associationBarJdbc.deleteById(101);

        /*Using MyBatis loading Class objects into DB*/
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        for (LawFirm lawFirm : data.lawFirmMyBatisData()) {
            lawFirmMyBatis.insert(lawFirm);
            for (Attorney attorney : lawFirm.getAttorneyList()) {
                attorneyMyBatis.insert(attorney, lawFirm.getLawFirmId());
                for (Integer associationBarId : attorney.getAssociationBarIdList()) {
                    attorneyAssociationBarMyBatis.insert(associationBarId, attorney);
                }
            }
        }
        /*Using JDBC Inserting class Objects into DB*/
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        for (LawFirm lawFirm : data.lawFirmJdbcData()) {
            lawFirmJdbc.insert(lawFirm);
        }

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

//        logger.info("Updating Attorney city");
//        attorneyService.updateCityById(1000, "Dayton");
//        logger.info("Adding Association Bar to an attorney");
//        attorneyAssociationBarService.addAssociationBar(1000, 102);



        /*DOM PARSER*/
        DomParser domParser = new DomParser();
        domParser.initializer("src/main/resources/dom/lawfirmDom.xml");
        ArrayList<Court> courtList = domParser.courtParser(); //Converting XML file to class Objects
        for (Court court : courtList) {
            Judge judge = court.getJudge();
            /*Using MyBatis loading class objects into DB*/
            judgeMyBatis.insert(judge);
            courtMyBatis.insert(court, judge.getJudgeId());
            ArrayList<CaseFiled> caseFiledList = court.getCaseFiledList();
            for (CaseFiled caseFiled : caseFiledList) {
                caseFiledMyBatis.insert(caseFiled, caseFiled.getClientId());
            }
        }

////        SaxParser saxParser = new SaxParser();
////        File file = new File("src/main/resources/lawfirmDom.xml");
////        saxParser.readXmlFile(file);

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
//
//

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
        /*Writing class Objects into Json File*/
        jacksonParser.writeXmlFile(clients);
    }
}
