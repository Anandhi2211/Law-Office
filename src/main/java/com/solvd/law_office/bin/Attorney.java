package com.solvd.law_office.bin;

import java.util.ArrayList;

public class Attorney extends AssociationBar  {
    private int attorney_id;
    private String attorney_name;
    private String country;
    private String city;

    public ArrayList<Integer> getClientIdList() {
        return this.clientIdList;
    }
    public void setClientIdList(Integer clientIdList) {
        this.clientIdList.add(clientIdList);
    }
    private ArrayList<Integer> clientIdList;

    public ArrayList<Integer> getAssociationBarIdList() {
        return this.associationBarIdList;
    }

    public void setAssociationBarIdList(int associationBarId) {
        if(this.associationBarIdList==null){
            this.associationBarIdList = new ArrayList<>();
        }
        this.associationBarIdList.add(associationBarId);
    }

    private ArrayList<Integer> associationBarIdList;

    public ArrayList<AssociationBar> getAssociationBarList() {
        return this.associationBarList;
    }

    public void setAssociationBarList(AssociationBar associationBar) {
        if(this.associationBarList == null){
            this.associationBarList = new ArrayList<>();
        }
        this.associationBarList.add(associationBar);
    }

    private ArrayList<AssociationBar> associationBarList;
    public int getAttorney_id() {
        return attorney_id;
    }

    public void setAttorney_id(int attorney_id) {
        this.attorney_id = attorney_id;
    }

    public String getAttorney_name() {
        return this.attorney_name;
    }

    public void setAttorney_name(String attorney_name) {
        this.attorney_name = attorney_name;
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
