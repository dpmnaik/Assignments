package com.Tekion.Cricket;

import java.util.ArrayList;

public class Team {
    private final String TeamName;
    private ArrayList<Player> teamPlayers;
    private int teamScore;
    private int teamWickets;
    private String oversPlayed;


    public Team(String tname) {
        TeamName = tname;
        teamWickets=0;
        teamScore=0;
        teamPlayers= new ArrayList<>();
    }

    public void updateOvers(String op)
    {
        oversPlayed=op;
    }

    public String getOversPlayed() {
        return oversPlayed;
    }

    public int getTeamWickets() {
        return teamWickets;
    }

    public void updateTeamScore(int ts)
    {
        teamScore=ts;
    }

    public void updateTeamWickets(int tw)
    {
        teamWickets=tw;
    }
    public int getTeamScore() {
        return teamScore;
    }

    public void addPlayer(Player player)
    {
        teamPlayers.add(player);
    }

    public String getTname() {
        return TeamName;
    }

    public Player getPlayer(int i) {
        return teamPlayers.get(i);
    }
}
