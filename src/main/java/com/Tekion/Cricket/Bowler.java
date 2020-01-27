package com.Tekion.Cricket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"Name","Overs","Runs Given","Wickets Taken","Maiden Overs"})
public class Bowler extends Player {
    private int noOfOvers;
    private int runsGiven;
    private int wicketsTaken;
    private int maidenOvers;

    public Bowler(String pName, int D_rating, int R_rating, int A_rating) {
        super(pName, D_rating, R_rating, A_rating);
        noOfOvers=0;
        runsGiven=0;
        wicketsTaken=0;
        maidenOvers=0;
    }

    public void updateOvers()
    {
        noOfOvers++;
    }

    public void updateRunsGiven(int rg)
    {
        runsGiven+=rg;
    }

    public void updateWicketsTaken()
    {
        wicketsTaken++;
    }

    public void updateMaidenOvers()
    {
        maidenOvers++;
    }


    @Override
    public String getpName() {
        return super.getpName();
    }

    @JsonIgnore
    @Override
    public int getNoOfRuns() {
        return super.getNoOfRuns();
    }

    @JsonIgnore
    @Override
    public int getBallsFaced() {
        return super.getBallsFaced();
    }

    @JsonIgnore
    @Override
    public int getBoundaries() {
        return super.getBoundaries();
    }


    @JsonProperty("Overs")
    public int getNoOfOvers() {
        return noOfOvers;
    }

    @JsonProperty("Runs Given")
    public int getRunsGiven() {
        return runsGiven;
    }

    @JsonProperty("Wickets Taken")
    public int getWicketsTaken() {
        return wicketsTaken;
    }

    @JsonProperty("Maiden Overs")
    public int getMaidenOvers() {
        return maidenOvers;
    }
}
