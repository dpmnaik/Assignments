package com.Tekion.Cricket;

import java.util.ArrayList;

public class CricketGame {
    private int tossResult;
    private static int firstInningsScore=Integer.MAX_VALUE;
    private static char []ballOutcome={'0','1','2','3','4','5','6','W'};
//    private static int [] high={70,20,10,5,10,1,3,3};
//    private static int [] good={60,7,5,2,18,1,7,8};
//    private static int [] bad={80,10,5,2,4,2,2,12};

    private int findCeil(int[] arr, int r, int l, int h)
    {
        int mid;
        while (l < h)
        {
            mid = l + ((h - l) >> 1);
            if(r > arr[mid])    l = mid + 1;
            else h = mid;
        }
        return (arr[l] >= r) ? l : -1;
    }

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
            ch=ballResult(player.getFreq());
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


    private char ballResult(int[] freq)
    {
        int[] prefix =new int[8];
        int i;
        prefix[0] = freq[0];
        for (i = 1; i < 8; ++i)
            prefix[i] = prefix[i - 1] + freq[i];

        int r = (int)(Math.random() * prefix[7]);


        int indexc = findCeil(prefix, r, 0, 7);
        return ballOutcome[indexc];
    }


    public int getTossResult() {
        return tossResult;
    }
}
