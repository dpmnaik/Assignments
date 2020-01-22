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

        if(match.getMatchTossResult().compareTo("Team A batting first")==0)
            return new MatchResult(match.getMatchTossResult(),
                    new InningScoreCard(match.getTeam1().getTeamScore()+"/"+match.getTeam1().getTeamWickets(),
                        match.getTeam1().getTeamName(),
                        match.getTeam2().getTeamName(),
                        match.getTeam1().getTeamPlayers(),
                        match.getTeam2().getTeamBowlers()),
                    new InningScoreCard(match.getTeam2().getTeamScore()+"/"+match.getTeam2().getTeamWickets(),
                            match.getTeam2().getTeamName(),
                            match.getTeam1().getTeamName(),
                            match.getTeam2().getTeamPlayers(),
                            match.getTeam1().getTeamBowlers()),
                match.getResult());
        else
            return new MatchResult(match.getMatchTossResult(),
                    new InningScoreCard(match.getTeam2().getTeamScore()+"/"+match.getTeam2().getTeamWickets(),
                            match.getTeam2().getTeamName(),
                            match.getTeam1().getTeamName(),
                            match.getTeam2().getTeamPlayers(),
                            match.getTeam1().getTeamBowlers()),
                    new InningScoreCard(match.getTeam1().getTeamScore()+"/"+match.getTeam1().getTeamWickets(),
                            match.getTeam1().getTeamName(),
                            match.getTeam2().getTeamName(),
                            match.getTeam1().getTeamPlayers(),
                            match.getTeam2().getTeamBowlers()),
                    match.getResult());
    }
}
