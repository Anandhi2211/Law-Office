package com.solvd.lawoffice;

import com.solvd.lawoffice.binary.AreaOfPractice;
import com.solvd.lawoffice.binary.AssociationBar;
import com.solvd.lawoffice.binary.Attorney;
import com.solvd.lawoffice.binary.LawFirm;

import java.util.ArrayList;

public class DataGenerator {
    public ArrayList<LawFirm> lawFirmData() {
        ArrayList<LawFirm> lawFirmList = new ArrayList<>();
        LawFirm lawFirm = new LawFirm();
        lawFirm.setLawFirmId(108);
        lawFirm.setLawFirmName("Kohls Co");
        lawFirm.setAddress("20 Tyler street");
        lawFirm.setCountry("USA");
        lawFirm.setCity("Charlotte");

        Attorney attorney = new Attorney();
        attorney.setAttorneyId(1020);
        attorney.setAttorneyName("Reka");
        attorney.setCountry("USA");
        attorney.setCity("Charlotte");
        attorney.setAssociationBarIdList(100);
        attorney.setAssociationBarIdList(103);
        attorney.setAssociationBarIdList(102);
        lawFirm.setAttorneyList(attorney);

        attorney = new Attorney();
        attorney.setAttorneyId(1021);
        attorney.setAttorneyName("Kavin");
        attorney.setCountry("USA");
        attorney.setCity("Harrisburg");
        lawFirm.setAttorneyList(attorney);
        lawFirmList.add(lawFirm);

        lawFirm = new LawFirm();
        lawFirm.setLawFirmId(109);
        lawFirm.setLawFirmName("Anand and Laks");
        lawFirm.setAddress("202 Paris LANE");
        lawFirm.setCountry("USA");
        lawFirm.setCity("ohio");

        attorney = new Attorney();
        attorney.setAttorneyId(1022);
        attorney.setAttorneyName("Nitin");
        attorney.setCountry("USA");
        attorney.setCity("cincinnati");
        attorney.setAssociationBarIdList(100);
        attorney.setAssociationBarIdList(103);

        lawFirm.setAttorneyList(attorney);

        attorney = new Attorney();
        attorney.setAttorneyId(1023);
        attorney.setAttorneyName("Sugaa");
        attorney.setCountry("USA");
        attorney.setCity("Dayton");
        attorney.setAssociationBarIdList(102);
        attorney.setAssociationBarIdList(104);
        lawFirm.setAttorneyList(attorney);
        lawFirmList.add(lawFirm);

        return lawFirmList;
    }

    public ArrayList<AssociationBar> associationBarCreation() {
        ArrayList<AssociationBar> associationBarArrayList = new ArrayList<>();
        AssociationBar associationBar = new AssociationBar();
        associationBar.setAssociationBarId(111);
        associationBar.setAssociationBarName("Union Bar");
        associationBarArrayList.add(associationBar);

        associationBar = new AssociationBar();
        associationBar.setAssociationBarId(112);
        associationBar.setAssociationBarName("Mason County Bar");
        associationBarArrayList.add(associationBar);

        associationBar = new AssociationBar();
        associationBar.setAssociationBarId(113);
        associationBar.setAssociationBarName("Harrisburg Bar");
        associationBarArrayList.add(associationBar);

        associationBar = new AssociationBar();
        associationBar.setAssociationBarId(114);
        associationBar.setAssociationBarName("Troy Bar");
        associationBarArrayList.add(associationBar);

        associationBar = new AssociationBar();
        associationBar.setAssociationBarId(115);
        associationBar.setAssociationBarName("Miami Bar");
        associationBarArrayList.add(associationBar);

        return associationBarArrayList;
    }

    public ArrayList<AreaOfPractice> AreaOfPractices() {
        ArrayList<AreaOfPractice> areaOfPracticeList = new ArrayList<>();
        AreaOfPractice areaOfPractice = new AreaOfPractice();
        areaOfPractice.setAreaOfPracticeId(10);
        areaOfPractice.setAreaOfPracticeName("Criminal Law");
        areaOfPracticeList.add(areaOfPractice);
        return areaOfPracticeList;
    }
}
