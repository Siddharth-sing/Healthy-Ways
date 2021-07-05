package com.siddharthsinghbaghel.healthyways.pojo;

import java.util.List;

public class Item {
    private Issue Issue;
    private List<Specialisation> Specialisation = null;

    public Issue getIssue() {
        return Issue;
    }

    public void setIssue(Issue issue) {
        this.Issue = issue;
    }

    public List<Specialisation> getSpecialisation() {
        return Specialisation;
    }

    public void setSpecialisation(List<Specialisation> specialisation) {
        this.Specialisation = specialisation;
    }
}
