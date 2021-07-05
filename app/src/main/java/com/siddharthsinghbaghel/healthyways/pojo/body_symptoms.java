package com.siddharthsinghbaghel.healthyways.pojo;

import java.util.List;

public class body_symptoms {
    private int ID;
    private String Name;
    private boolean HasRedFlag;
    private List<Integer> HealthSymptomLocationIDs = null;
    private String ProfName;
    private List<String> Synonyms = null;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public boolean isHasRedFlag() {
        return HasRedFlag;
    }

    public void setHasRedFlag(boolean hasRedFlag) {
        this.HasRedFlag = hasRedFlag;
    }

    public List<Integer> getHealthSymptomLocationIDs() {
        return HealthSymptomLocationIDs;
    }

    public void setHealthSymptomLocationIDs(List<Integer> healthSymptomLocationIDs) {
        this.HealthSymptomLocationIDs = healthSymptomLocationIDs;
    }

    public String getProfName() {
        return ProfName;
    }

    public void setProfName(String profName) {
        this.ProfName = profName;
    }

    public List<String> getSynonyms() {
        return Synonyms;
    }

    public void setSynonyms(List<String> synonyms) {
        this.Synonyms = synonyms;
    }
}
