package com.solvd.lawoffice.db.binary;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="award")
@XmlAccessorType(XmlAccessType.FIELD)

public class Award {
    @XmlAttribute(name ="id")
    private int awardId;
    private String awardName;
    public int getAwardId() {
        return awardId;
    }
    public void setAwardId(int awardId) {
        this.awardId = awardId;
    }
    public String getAwardName() {
        return awardName;
    }
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }


}
