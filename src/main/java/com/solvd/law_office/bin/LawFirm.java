package com.solvd.law_office.bin;

import java.util.ArrayList;

public class LawFirm {
    private int lawFirmId;
    private String lawFirmName;
    private String address;
    private String country;
    private String city;
    private ArrayList<Attorney> attorneyList;
    private ArrayList<Client> clientList;

    public int getLawFirmId() {
        return this.lawFirmId;
    }

    public void setLawFirmId(int lawFirmId) {
        this.lawFirmId = lawFirmId;
    }

    public String getLawFirmName() {
        return this.lawFirmName;
    }

    public void setLawFirmName(String lawFirmName) {
        this.lawFirmName = lawFirmName;
    }
    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public ArrayList<Attorney> getAttorneyList() {
        return this.attorneyList;
    }

    public void setAttorneyList(Attorney attorney) {
        if(this.attorneyList==null)
        {
            this.attorneyList = new ArrayList<>();
        }
        this.attorneyList.add(attorney);
    }

    public ArrayList<Client> getClientList() {
        return this.clientList;
    }

    public void setClientList(Client client) {
        if(this.clientList == null)
        {
            this.clientList = new ArrayList<>();
        }
        this.clientList.add(client);
    }
}
