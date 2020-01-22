package com.Tekion.Cricket;

import java.util.ArrayList;

public class InningScoreCard {

    private String Score;
    private String battingTeam;
    private String bowlingTeam;
    private ArrayList<Player> batsmen;
    private ArrayList<Bowler> bowlers;

    public InningScoreCard(String score, String battingTeam, String bowlingTeam, ArrayList<Player> batsmen, ArrayList<Bowler> bowlers) {
        Score = score;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.batsmen = batsmen;
        this.bowlers = bowlers;
    }

    public String getScore() {
        return Score;
    }

    public String getBattingTeam() {
        return battingTeam;
    }

    public String getBowlingTeam() {
        return bowlingTeam;
    }

    public ArrayList<Player> getBatsmen() {
        return batsmen;
    }

    public ArrayList<Bowler> getBowlers() {
        return bowlers;
    }
}
