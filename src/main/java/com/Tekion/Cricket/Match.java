package com.Tekion.Cricket;

import java.util.Arrays;

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
        for(int i=0;i<3;i++)
        {
            team1.addPlayer(new Player("PA"+(i+1),85,75,40));
            team2.addPlayer(new Player("PB"+(i+1),85,75,40));
        }
        for(int i=0;i<3;i++)
        {
            team1.addPlayer(new Player("PA"+(i+3),60,50,85));
            team2.addPlayer(new Player("PB"+(i+3),60,50,85));
        }
        for(int i=0;i<5;i++)
        {
            team1.addPlayer(new Player("PA"+(i+7),40,60,40));
            team1.addBowler(new Bowler("PA"+(i+7),40,60,40));
            team2.addPlayer(new Player("PB"+(i+7),40,60,40));
            team2.addBowler(new Bowler("PB"+(i+7),40,60,40));
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
            matchTossResult="Team A won the toss and choose to bat";
            //playing first inning
            res=cgame.playInning(true,team1,team2);
            System.out.println(Arrays.toString(res));
            team1.updateTeamScore(res[0]);
            team1.updateTeamWickets(res[1]);
            if(res[2]<=300)
                team1.updateOvers((res[2]/6)+"."+(res[2]%6));
            else
                team1.updateOvers(res[2]/6+".0");

            //playing second innings
            res=cgame.playInning(false,team2,team1);
            System.out.println(Arrays.toString(res));
            team2.updateTeamScore(res[0]);
            team2.updateTeamWickets(res[1]);
            if(res[2]<=300)
                team2.updateOvers((res[2]/6)+"."+(res[2]%6));
            else
                team2.updateOvers(res[2]/6+".0");
        }
        else
        {
            matchTossResult="Team B won the toss and choose to bat";
            //first inning
            res=cgame.playInning(true,team2,team1);
            System.out.println(Arrays.toString(res));
            team2.updateTeamScore(res[0]);
            team2.updateTeamWickets(res[1]);
            if(res[2]<=300)
                team2.updateOvers((res[2]/6)+"."+(res[2]%6));
            else
                team2.updateOvers(res[2]/6+".0");

            //second inning
            res=cgame.playInning(false,team1,team2);
            System.out.println(Arrays.toString(res));
            team1.updateTeamScore(res[0]);
            team1.updateTeamWickets(res[1]);
            if(res[2]<=300)
                team1.updateOvers((res[2]/6)+"."+(res[2]%6));
            else
                team1.updateOvers(res[2]/6+".0");
        }
    }

    public void endGame()
    {
        if(matchTossResult.equals("Team A won the toss and choose to bat")){
            if(team1.getTeamScore()>team2.getTeamScore()) Result=team1.getTeamName()+" won by "+(team1.getTeamScore()-team2.getTeamScore())+" runs";
            else if(team2.getTeamScore()>team1.getTeamScore()) Result=team2.getTeamName()+" won by " +(10-team2.getTeamWickets())+" wickets";
            else Result="Game Tied";
        }
        else
        {
            if(team1.getTeamScore()>team2.getTeamScore()) Result=team1.getTeamName()+" won by " +(10-team1.getTeamWickets())+" wickets";
            else if(team2.getTeamScore()>team1.getTeamScore()) Result=team2.getTeamName()+" won by "+(team1.getTeamScore()-team2.getTeamScore())+" runs";
            else Result="Game Tied";
        }

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
