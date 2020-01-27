package com.Tekion.Cricket;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonPropertyOrder({ "battingTeam", "bowlingTeam","Total","Overs","batsmen","bowler" })
public class InningScoreCard {

    private String Score;
    private String Overs;
    private String battingTeam;
    private String bowlingTeam;
    private ArrayList<Player> batsmen;
    private ArrayList<Bowler> bowlers;

    public InningScoreCard(String score, String overs, String battingTeam, String bowlingTeam, ArrayList<Player> batsmen, ArrayList<Bowler> bowlers) {
        Score = score;
        Overs = overs;
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.batsmen = batsmen;
        this.bowlers = bowlers;
    }

    @JsonProperty("Total")
    public String getScore() {
        return Score;
    }

    @JsonProperty("Overs")
    public String getOvers() {
        return Overs;
    }

    @JsonProperty("Batting Team")
    public String getBattingTeam() {
        return battingTeam;
    }

    @JsonProperty("Bowling Team")
    public String getBowlingTeam() {
        return bowlingTeam;
    }

    @JsonProperty("Batsmen")
    public ArrayList<Player> getBatsmen() {
        return batsmen;
    }

    @JsonProperty("Bowlers")
    public ArrayList<Bowler> getBowlers() {
        return bowlers;
    }
}
