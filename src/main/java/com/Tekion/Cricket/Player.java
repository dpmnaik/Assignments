package com.Tekion.Cricket;

public class Player {
    protected String pName;
    protected int noOfRuns;
    protected int ballsFaced;
    protected int boundaries;

    public Player(String pName)
    {
        this.pName=pName;
        noOfRuns=0;
        ballsFaced=0;
        boundaries=0;
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

    public String getpName() {
        return pName;
    }

    public int getNoOfRuns() {
        return noOfRuns;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public int getBoundaries() {
        return boundaries;
    }
}
