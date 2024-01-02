package com.solvd.law_office.bin;

import java.util.ArrayList;

public class Court {
    @Override
    public String toString() {
        return "Court{" +
                "courtId=" + courtId +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", judge=" + judge +
                ", caseFiledList=" + caseFiledList +
                '}';
    }

    private int courtId;
    private String country;
    private String city;
    private Judge judge;

    public ArrayList<CaseFiled> getCaseFiledList() {
        return caseFiledList;
    }

    public void setCaseFiledList(CaseFiled caseFiledList) {
        if(this.caseFiledList==null){
            this.caseFiledList = new ArrayList<>();
        }
        this.caseFiledList.add(caseFiledList);
    }

    private ArrayList<CaseFiled> caseFiledList;

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public Judge getJudge() {
        return judge;
    }

    public void setJudge(Judge judge) {
        this.judge = judge;
    }
}
