package com.Tekion.Cricket;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Bowler extends Player {
    private int noOfOvers;
    private int runsGiven;
    private int wicketsTaken;
    private int maidenOvers;

    public Bowler(String pName) {
        super(pName);
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

    public int getNoOfOvers() {
        return noOfOvers;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public int getMaidenOvers() {
        return maidenOvers;
    }
}
