package com.solvd.law_office.bin;

public class Judge {
    private int judgeId;
    private String judgeName;

    @Override
    public String toString() {
        return "Judge{" +
                "judgeId=" + judgeId +
                ", judgeName='" + judgeName + '\'' +
                '}';
    }

    public Judge() {
    }

    public int getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(int judgeId) {
        this.judgeId = judgeId;
    }

    public String getJudgeName() {
        return judgeName;
    }

    public void setJudgeName(String judgeName) {
        this.judgeName = judgeName;
    }
}
