package com.Tekion.Cricket;

public class MatchResult {
    private final String tossResult;
    private final String teamA_Name;
    private final String teamA_Score;
    private final String teamA_Overs;
    private final String teamB_Name;
    private final String teamB_Score;
    private final String teamB_Overs;
    private final String result;

    public MatchResult(String tossResult, String teamA_Name, String teamA_Score, String teamA_Overs, String teamB_Name, String teamB_Score, String teamB_Overs, String result) {
        this.tossResult = tossResult;
        this.teamA_Name = teamA_Name;
        this.teamA_Score = teamA_Score;
        this.teamA_Overs = teamA_Overs;
        this.teamB_Name = teamB_Name;
        this.teamB_Score = teamB_Score;
        this.teamB_Overs = teamB_Overs;
        this.result = result;
    }

    public String getTossResult() {
        return tossResult;
    }

    public String getTeamA_Name() {
        return teamA_Name;
    }

    public String getTeamA_Score() {
        return teamA_Score;
    }

    public String getTeamA_Overs() {
        return teamA_Overs;
    }

    public String getTeamB_Name() {
        return teamB_Name;
    }

    public String getTeamB_Score() {
        return teamB_Score;
    }

    public String getTeamB_Overs() {
        return teamB_Overs;
    }

    public String getResult() {
        return result;
    }
}
