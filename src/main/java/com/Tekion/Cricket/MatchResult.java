package com.Tekion.Cricket;


public class MatchResult {

    private final String tossResult;
    private InningScoreCard firstInning;
    private InningScoreCard secondInning;
    private final String result;


    public MatchResult(String tossResult, InningScoreCard firstInning, InningScoreCard secondInning, String result) {
        this.tossResult = tossResult;
        this.firstInning = firstInning;
        this.secondInning = secondInning;
        this.result = result;
    }

    public String getTossResult() {
        return tossResult;
    }

    public InningScoreCard getFirstInning() {
        return firstInning;
    }

    public InningScoreCard getSecondInning() {
        return secondInning;
    }

    public String getResult() {
        return result;
    }
}
