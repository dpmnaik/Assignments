package com.Tekion.Cricket;

import java.util.ArrayList;

public class CricketGame {
    private int tossResult;
    private static int firstInningsScore=Integer.MAX_VALUE;
    public void doToss()
    {
        tossResult = (int)(Math.random()*2);
    }

    public int[] playInning(boolean first,Team batting,Team bowling)
    {
        ArrayList<Player> currBatsmen=new ArrayList<>();
        currBatsmen.add(batting.getPlayer(0));
        currBatsmen.add(batting.getPlayer(1));
        int currBatsmenIndex=0,currBowlerIndex=0;
        int inningScore = 0,overScore=0,batsmenScore=0;
        int wickets = 0;
        char ch;
        int i;
        for(i=1;i<=300;i++)
        {
            Player player=currBatsmen.get(currBatsmenIndex);
            player.updateBallsFaced();
            ch=ballResult();
            if(ch=='W'){
                wickets++;
                Bowler bowler=bowling.getBowler(currBowlerIndex);
                bowler.updateWicketsTaken();
                if(wickets ==10) break;
                currBatsmen.set(currBatsmenIndex,batting.getPlayer(wickets+1));
            }
            else
            {
                int ballRun=ch-48;
                inningScore += ballRun;
                overScore+=ballRun;
                player.updateScore(ballRun);
                if(ballRun==4 || ballRun==6) player.updateBoundaries();
                if((ballRun%2)==1) currBatsmenIndex=(currBatsmenIndex+1)%2;
                if(!first && inningScore >firstInningsScore) break;
            }
            if(i%6==0)
            {
                Bowler bowler=bowling.getBowler(currBowlerIndex);
                bowler.updateOvers();
                bowler.updateRunsGiven(overScore);
                if(overScore==0) bowler.updateMaidenOvers();
                currBowlerIndex= (currBowlerIndex+1)%5;
                currBatsmenIndex=(currBatsmenIndex+1)%2;
                overScore=0;
            }
        }

        firstInningsScore=inningScore;
        return new int[]{inningScore, wickets,i};
    }

    private char ballResult()
    {
        int rand=(int)(Math.random()*8);
        if(rand==7) return 'W';
        else return (char)(rand+48); //converting random no into char
    }

    public int getTossResult() {
        return tossResult;
    }
}
