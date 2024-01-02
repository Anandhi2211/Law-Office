package com.solvd.law_office.bin;

public class CaseFiled {
    private int caseFiledId;
    private String caseDescription;

    @Override
    public String toString() {
        return "CaseFiled{" +
                "caseFiledId=" + caseFiledId +
                ", caseDescription='" + caseDescription + '\'' +
                ", clientId=" + clientId +
                ", courtId=" + courtId +
                ", caseCategoryId=" + caseCategoryId +
                ", attorneyId=" + attorneyId +
                '}';
    }

    private int clientId;
    private int courtId;
    private int caseCategoryId;
    private int attorneyId;

    public int getCaseFiledId() {
        return caseFiledId;
    }

    public void setCaseFiledId(int caseFiledId) {
        this.caseFiledId = caseFiledId;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getCourtId() {
        return courtId;
    }

    public void setCourtId(int courtId) {
        this.courtId = courtId;
    }

    public int getCaseCategoryId() {
        return caseCategoryId;
    }

    public void setCaseCategoryId(int caseCategoryId) {
        this.caseCategoryId = caseCategoryId;
    }

    public int getAttorneyId() {
        return attorneyId;
    }

    public void setAttorneyId(int attorneyId) {
        this.attorneyId = attorneyId;
    }
}
