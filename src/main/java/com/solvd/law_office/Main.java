package com.solvd.law_office;
import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.bin.LawFirm;
import com.solvd.law_office.service.AssociationBarService;
import com.solvd.law_office.service.impl.AssociationBarServiceImpl;
import com.solvd.law_office.service.impl.LawFirmServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args)
    {
        DataGenerator data = new DataGenerator();
        LawFirmServiceImpl lawFirmService = new LawFirmServiceImpl();
        AssociationBarServiceImpl associationBarService = new AssociationBarServiceImpl();
        logger.info("Inserting data into Association_Bars Table");
        for(AssociationBar associationBar : data.associationBarCreation())
        {
            associationBarService.insert(associationBar);
        }
        logger.info("Inserting data into Law_firms, Attorneys, AttorneyAssociationBar Tables");
        for(LawFirm lawFirm : data.lawFirmCreation()){
            lawFirmService.insert(lawFirm);
        }
        logger.info("Displaying LawFirms Table");

        ArrayList<LawFirm> lawFirmList = lawFirmService.findAll();
        for(LawFirm lawFirm : lawFirmList){
            logger.info("Law Firm Id: "+lawFirm.getLawFirmId());
        }

    }
}