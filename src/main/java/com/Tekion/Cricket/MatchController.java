package com.Tekion.Cricket;

public class MatchController {
    private Match match;

    public MatchController()
    {
        match=new Match();
        match.startPlaying();
        match.endGame();
    }

    public MatchResult getMatchResult()
    {
        return new MatchResult(match.getMatchTossResult(),
                match.getTeam1().getTname(),
                match.getTeam1().getTeamScore()+"/"+match.getTeam1().getTeamWickets(),
                match.getTeam1().getOversPlayed(),
                match.getTeam2().getTname(),
                match.getTeam2().getTeamScore()+"/"+match.getTeam2().getTeamWickets(),
                match.getTeam2().getOversPlayed(),
                match.getResult());
    }
}
