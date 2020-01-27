package com.Tekion.Cricket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Player {
    protected String pName;
    protected int noOfRuns;
    protected int ballsFaced;
    protected int boundaries;
    protected int D_rating,R_rating,A_rating;
    private int []freq;
    public Player(String pName,int D_rating,int R_rating,int A_rating)
    {
        this.pName=pName;
        noOfRuns=0;
        ballsFaced=0;
        boundaries=0;
        this.R_rating=R_rating;
        this.D_rating=D_rating;
        this.A_rating=A_rating;
        freq=new int[8];
        createFreq();
    }

    private void createFreq()
    {
        freq[0]=D_rating+20;
        freq[1]= (int) Math.ceil(0.52*R_rating-4.32);
        freq[2]= (int) Math.ceil(freq[1]/2.0);
        freq[3]= (int) Math.ceil(freq[1]/4.0);
        freq[4]= (int) Math.ceil(0.26*A_rating-2.25);
        freq[5]=1;
        freq[6]= (int) Math.ceil(freq[4]/2.0);
        freq[7]= (int) Math.ceil(18.1-0.18*D_rating);
    }

    @JsonIgnore
    public int[] getFreq() {
        return freq;
    }

    public void updateScore(int sc)
    {
        noOfRuns+=sc;
    }

    public void updateBallsFaced()
    {
        ballsFaced++;
    }

    public void updateBoundaries()
    {
        boundaries++;
    }

    @JsonProperty("Name")
    public String getpName() {
        return pName;
    }

    @JsonProperty("Score")
    public int getNoOfRuns() {
        return noOfRuns;
    }

    @JsonProperty("Balls")
    public int getBallsFaced() {
        return ballsFaced;
    }

    @JsonProperty("Boundaries")
    public int getBoundaries() {
        return boundaries;
    }
}
