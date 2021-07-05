package com.siddharthsinghbaghel.healthyways.pojo;

public class Issue {

    private int Id;
    private String Name;
    private float Accuracy;
    private String Icd;
    private String IcdName;
    private String ProfName;
    private int Ranking;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public float getAccuracy() {
        return Accuracy;
    }

    public void setAccuracy(float accuracy) {
        this.Accuracy = accuracy;
    }

    public String getIcd() {
        return Icd;
    }

    public void setIcd(String icd) {
        this.Icd = icd;
    }

    public String getIcdName() {
        return IcdName;
    }

    public void setIcdName(String icdName) {
        this.IcdName = icdName;
    }

    public String getProfName() {
        return ProfName;
    }

    public void setProfName(String profName) {
        this.ProfName = profName;
    }

    public int getRanking() {
        return Ranking;
    }

    public void setRanking(int ranking) {
        this.Ranking = ranking;
    }

}
