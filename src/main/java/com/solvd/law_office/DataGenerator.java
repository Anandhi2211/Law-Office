package com.solvd.law_office;

import com.solvd.law_office.bin.*;

import java.util.ArrayList;

public class DataGenerator {

    public ArrayList<LawFirm> lawFirmCreation() {
        ArrayList<LawFirm> lawFirmList = new ArrayList<>();
        LawFirm lawFirm = new LawFirm();
        lawFirm.setLawFirmId(105);
        lawFirm.setLawFirmName("Amarnath Co");
        lawFirm.setAddress("20 Glen street");
        lawFirm.setCountry("USA");
        lawFirm.setCity("Charlotte");

        Attorney attorney = new Attorney();
        attorney.setAttorneyId(1008);
        attorney.setAttorneyName("Sumedha");
        attorney.setCountry("USA");
        attorney.setCity("Charlotte");
        attorney.setAssociationBarIdList(100);
        attorney.setAssociationBarIdList(101);
        attorney.setAssociationBarIdList(102);
        lawFirm.setAttorneyList(attorney);

        attorney = new Attorney();
        attorney.setAttorneyId(1009);
        attorney.setAttorneyName("Kavinya");
        attorney.setCountry("USA");
        attorney.setCity("Harrisburg");
        lawFirm.setAttorneyList(attorney);
        lawFirmList.add(lawFirm);

        lawFirm = new LawFirm();
//        client = new Client();
        lawFirm.setLawFirmId(107);
        lawFirm.setLawFirmName("Anand and Laks");
        lawFirm.setAddress("202 Paris LANE");
        lawFirm.setCountry("USA");
        lawFirm.setCity("ohio");

        attorney = new Attorney();
        attorney.setAttorneyId(1010);
        attorney.setAttorneyName("Nithya");
        attorney.setCountry("USA");
        attorney.setCity("cincinnati");
        attorney.setAssociationBarIdList(100);
        attorney.setAssociationBarIdList(101);

        lawFirm.setAttorneyList(attorney);

        attorney = new Attorney();
        attorney.setAttorneyId(1011);
        attorney.setAttorneyName("Suganya");
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
