package com.solvd.law_office;

import com.solvd.law_office.bin.AreaOfPractice;
import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.bin.LawFirm;
import com.solvd.law_office.service.impl.AreaOfPracticeServiceImpl;
import com.solvd.law_office.service.impl.AssociationBarServiceImpl;
import com.solvd.law_office.service.impl.AttorneyServiceImpl;
import com.solvd.law_office.service.impl.LawFirmServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DataGenerator data = new DataGenerator();
        LawFirmServiceImpl lawFirmService = new LawFirmServiceImpl();
        AttorneyServiceImpl attorneyService = new AttorneyServiceImpl();
        AssociationBarServiceImpl associationBarService = new AssociationBarServiceImpl();
        AreaOfPracticeServiceImpl areaOfPracticesService = new AreaOfPracticeServiceImpl();
        logger.info("Inserting data into Association_Bars Table");
        for (AssociationBar associationBar : data.associationBarCreation()) {
            associationBarService.insert(associationBar);
        }
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        for (LawFirm lawFirm : data.lawFirmCreation()) {
            lawFirmService.insert(lawFirm);
        }
        logger.info("Finding Attorney by ID");
        ArrayList<Attorney> attorneyList = attorneyService.findById(1001);
        if (attorneyList != null) {
            for (Attorney attorney : attorneyList) {
                logger.info("Name: " + attorney.getAttorneyName());
                logger.info("Id: " + attorney.getAttorneyId());
                logger.info("country: " + attorney.getCountry());
                logger.info("city: " + attorney.getCity());
                logger.info("LawFirm: " + attorney.getLawFirmId());
            }
        }
        logger.info("Finding Attorney By country Name");
        ArrayList<Attorney> attorneyList1 = attorneyService.findByCountry("USA");
        if (attorneyList1 != null) {
            for (Attorney attorney : attorneyList1) {
                logger.info("Name: " + attorney.getAttorneyName());
                logger.info("country: " + attorney.getCountry());
            }
        }
        logger.info("Adding Attorney Area of practices");
        for (AreaOfPractice areaOfPractice : data.AreaOfPractices()) {
            areaOfPracticesService.insert(areaOfPractice);
        }
        logger.info("Deleting 1 Association bar from Association bar table as well as attorney Association bar table");
        associationBarService.deleteById(101);

//        logger.info("Deleting attorney from attorney Table as well as from Attorney Association bar table since attorney id is a foreign Key");
//        attorneyService.deleteById(1001);

//        logger.info("**********************");
//        logger.info("Displaying LawFirms Table");
//        ArrayList<LawFirm> lawFirmList = lawFirmService.findAll();
//        for (LawFirm lawFirm : lawFirmList) {
//            logger.info("Law Firm Id: " + lawFirm.getLawFirmId());
//            logger.info("Law Firm Name: " + lawFirm.getLawFirmName());
//            logger.info("Address: " + lawFirm.getAddress());
//            logger.info("City: " + lawFirm.getCity());
//            logger.info("--------------");
//        }
//        logger.info("**********************");
//        logger.info("Displaying Attorney Table");
//        ArrayList<Attorney> attorneyList = attorneyService.findAll();
//        for (Attorney attorney : attorneyList) {
//            logger.info("Attorney Id: " + attorney.getAttorneyId());
//            logger.info("Attorney Name: " + attorney.getAttorneyName());
//            logger.info("Address: " + attorney.getCountry());
//            logger.info("City: " + attorney.getCity());
//            logger.info("Attorney Law Firm: " + attorney.getLawFirmId());
//            logger.info("--------------");
//        }
//        logger.info("**********************");
    }
}