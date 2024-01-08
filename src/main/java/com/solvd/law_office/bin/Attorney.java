package com.solvd.law_office.bin;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;

@XmlRootElement(name ="attorney")
@XmlAccessorType(XmlAccessType.FIELD)

public class Attorney    {
    @XmlAttribute(name = "id")
    private int attorneyId;
    private String attorneyName;
    private String country;
    private String city;
    private int lawFirmId;
    private ArrayList<Client> clientList;
    @XmlElementWrapper(name ="associationBarIdList")
    @XmlElement(name ="associationBarId")
    private ArrayList<Integer> associationBarIdList;
    public ArrayList<Client> getClientList() {
        return this.clientList;
    }
    public void setClientList(Client client) {
        this.clientList.add(client);
    }
    public int getLawFirmId() {
        return this.lawFirmId;
    }
    public void setLawFirmId(int lawFirmId) {
        this.lawFirmId = lawFirmId;
    }
    public void setAssociationBarIdList( Integer associationBarId) {
        if(this.associationBarIdList==null){
            this.associationBarIdList = new ArrayList<>();
        }
        this.associationBarIdList.add(associationBarId);    }
    public ArrayList<Integer> getAssociationBarIdList() {
        if(this.associationBarIdList == null){
            this.associationBarIdList = new ArrayList<>();
        }
        return this.associationBarIdList;
    }
    public int getAttorneyId() {
        return this.attorneyId;
    }
    public void setAttorneyId(int attorneyId) {
        this.attorneyId = attorneyId;
    }
    public String getAttorneyName() {
        return this.attorneyName;
    }
    public void setAttorneyName(String attorneyName) {
        this.attorneyName = attorneyName;
    }
    public String getCountry() {
        return this.country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
}
