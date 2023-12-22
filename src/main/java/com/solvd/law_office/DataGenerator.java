package com.solvd.law_office;

import com.solvd.law_office.bin.AssociationBar;
import com.solvd.law_office.bin.Attorney;
import com.solvd.law_office.bin.Client;
import com.solvd.law_office.bin.LawFirm;

import java.util.ArrayList;

public class DataGenerator {

    public ArrayList<LawFirm> lawFirmCreation()
    {
        ArrayList<LawFirm> lawFirmList = new ArrayList<>();
        LawFirm lawFirm = new LawFirm();
        Client client = new Client();
        lawFirm.setLawFirmId(100);
        lawFirm.setLawFirmName("Amarchand Co");
        lawFirm.setAddress("14th Ava street");
        lawFirm.setCountry("USA");
        lawFirm.setCity("Charlotte");

        client.setClientId(203);
        client.setClientName("Raji");
        client.setCountry("USA");
        client.setCity("charlotte");
        lawFirm.setClientList(client);

        client.setClientId(207);
        client.setClientName("Rajeev");
        client.setCountry("USA");
        client.setCity("charlotte");
        lawFirm.setClientList(client);


        Attorney attorney = new Attorney();
        attorney.setAttorney_id(1002);
        attorney.setAttorney_name("Kanmani");
        attorney.setCountry("USA");
        attorney.setCity("Charlotte");
        lawFirm.setAttorneyList(attorney);

        attorney = new Attorney();
        attorney.setAttorney_id(1003);
        attorney.setAttorney_name("Kavitha");
        attorney.setCountry("USA");
        attorney.setCity("Harrisburg");
        lawFirm.setAttorneyList(attorney);
        lawFirmList.add(lawFirm);

        lawFirm = new LawFirm();
        client = new Client();
        lawFirm.setLawFirmId(101);
        lawFirm.setLawFirmName("Anand & Anand");
        lawFirm.setAddress("90 BROADWAY LANE");
        lawFirm.setCountry("USA");
        lawFirm.setCity("ohio");

        client.setClientId(200);
        client.setClientName("Thamari");
        client.setCountry("USA");
        client.setCity("cincinnati");
        lawFirm.setClientList(client);

        client.setClientId(202);
        client.setClientName("Vishnu");
        client.setCountry("USA");
        client.setCity("cincinnati");
        lawFirm.setClientList(client);

        client.setClientId(204);
        client.setClientName("Som");
        client.setCountry("USA");
        client.setCity("cincinnati");
        lawFirm.setClientList(client);

        attorney = new Attorney();
        attorney.setAttorney_id(1000);
        attorney.setAttorney_name("Lakshmi");
        attorney.setCountry("USA");
        attorney.setCity("cincinnati");
        attorney.setAssociationBarIdList(100);
        attorney.setAssociationBarIdList(101);
        lawFirm.setAttorneyList(attorney);

        attorney = new Attorney();
        attorney.setAttorney_id(1001);
        attorney.setAttorney_name("Nithya");
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
        associationBar.setAssociationBarId(100);
        associationBar.setAssociationBarName("Akron Bar");
        associationBarArrayList.add(associationBar);

        associationBar = new AssociationBar();
        associationBar.setAssociationBarId(101);
        associationBar.setAssociationBarName("Butler County Bar");
        associationBarArrayList.add(associationBar);

        associationBar = new AssociationBar();
        associationBar.setAssociationBarId(102);
        associationBar.setAssociationBarName("Cleveland Bar");
        associationBarArrayList.add(associationBar);

        associationBar = new AssociationBar();
        associationBar.setAssociationBarId(103);
        associationBar.setAssociationBarName("Dayton Bar");
        associationBarArrayList.add(associationBar);

        associationBar = new AssociationBar();
        associationBar.setAssociationBarId(104);
        associationBar.setAssociationBarName("Cincinnati Bar");
        associationBarArrayList.add(associationBar);

        return associationBarArrayList;
    }
}
