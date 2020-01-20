package com.Tekion.Cricket;

public class CricketGame {
    private int tossResult;
    private static int firstInningsScore=Integer.MAX_VALUE;
    public void doToss()
    {
        tossResult = (int)(Math.random()*2);
    }

    public int[] playInning(boolean first)
    {
        int inningScore = 0;
        int wickets = 0;
        char ch;
        int i;
        for(i=0;i<300;i++)
        {
            ch=ballResult();
            if(ch=='W'){
                wickets++;
                if(wickets ==10) break;
            }
            else
            {
                inningScore += ch-48;
                if(!first && inningScore >firstInningsScore) break;
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
