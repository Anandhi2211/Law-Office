package com.solvd.law_office;

import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.bin.LawFirm;
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
        logger.info("Inserting data into Association_Bars Table");
        for (AssociationBar associationBar : data.associationBarCreation()) {
            associationBarService.insert(associationBar);
        }
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        for (LawFirm lawFirm : data.lawFirmCreation()) {
            lawFirmService.insert(lawFirm);
        }
        logger.info("**********************");
        logger.info("Displaying LawFirms Table");
        ArrayList<LawFirm> lawFirmList = lawFirmService.findAll();
        for (LawFirm lawFirm : lawFirmList) {
            logger.info("Law Firm Id: " + lawFirm.getLawFirmId());
            logger.info("Law Firm Name: " + lawFirm.getLawFirmName());
            logger.info("Address: " + lawFirm.getAddress());
            logger.info("City: " + lawFirm.getCity());
            logger.info("--------------");
        }
        logger.info("**********************");
        logger.info("Displaying Attorney Table");
        ArrayList<Attorney> attorneyList = attorneyService.findAll();
        for (Attorney attorney : attorneyList) {
            logger.info("Attorney Id: " + attorney.getAttorney_id());
            logger.info("Attorney Name: " + attorney.getAttorney_name());
            logger.info("Address: " + attorney.getCountry());
            logger.info("City: " + attorney.getCity());
            logger.info("Attorney Law Firm: " + attorney.getLawFirmId());
            logger.info("--------------");
        }
        logger.info("**********************");
    }
}