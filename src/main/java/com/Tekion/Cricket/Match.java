package com.Tekion.Cricket;

public class Match {
    private String Result;
    private String matchTossResult;
    private Team team1;
    private Team team2;

    public Match()
    {
        team1=new Team("Team A");
        team2=new Team("Team B");
    }


    private void createTeams()
    {
        for(int i=0;i<6;i++)
        {
            team1.addPlayer(new Player("PA"+(i+1)));
            team2.addPlayer(new Player("PB"+(i+1)));
        }
        for(int i=0;i<5;i++)
        {
            team1.addPlayer(new Player("PA"+(i+7)));
            team1.addBowler(new Bowler("PA"+(i+7)));
            team2.addPlayer(new Player("PB"+(i+7)));
            team2.addBowler(new Bowler("PB"+(i+7)));
        }
    }


    public void startPlaying()
    {
        CricketGame cgame=new CricketGame();
        createTeams();
        cgame.doToss();
        int []res;
        if(cgame.getTossResult()==0)
        {
            matchTossResult="Team A batting first";
            res=cgame.playInning(true,team1,team2);
            team1.updateTeamScore(res[0]);
            team1.updateTeamWickets(res[1]);
            team1.updateOvers((res[2]/6)+"."+(res[2]%6));
            res=cgame.playInning(false,team2,team1);
            team2.updateTeamScore(res[0]);
            team2.updateTeamWickets(res[1]);
            team2.updateOvers((res[2]/6)+"."+(res[2]%6));
        }
        else
        {
            matchTossResult="Team B batting first";
            res=cgame.playInning(true,team2,team1);
            team2.updateTeamScore(res[0]);
            team2.updateTeamWickets(res[1]);
            team2.updateOvers((res[2]/6)+"."+(res[2]%6));
            res=cgame.playInning(false,team1,team2);
            team1.updateTeamScore(res[0]);
            team1.updateTeamWickets(res[1]);
            team1.updateOvers((res[2]/6)+"."+(res[2]%6));
        }
    }

    public void endGame()
    {
        if(team1.getTeamScore()>team2.getTeamScore()) Result=team1.getTeamName()+" beat " +team2.getTeamName();
        else if(team2.getTeamScore()>team1.getTeamScore()) Result=team2.getTeamName()+" beat " +team1.getTeamName();
        else Result="Game Tied";
    }

    public String getResult()
    {
        return Result;
    }

    public String getMatchTossResult() {
        return matchTossResult;
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }
}
