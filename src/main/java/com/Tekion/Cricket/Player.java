package com.Tekion.Cricket;

public class Player {
    private String pName;
    private int score;

    public Player(String pName)
    {
        this.pName=pName;
        score=0;
    }

    public void updateScore(int sc)
    {
        score=sc;
    }
    public String getpName() {
        return pName;
    }

    public int getScore() {
        return score;
    }
}
