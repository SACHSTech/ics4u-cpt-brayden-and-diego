package cpt;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Team> a = readFile.readDataFile("src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv");
        Sortingpt2.sort(a,"ppg22");

        for (Team team : a) {
            System.out.println(team.getTeamName() + " : " + team.getPpg22());
        }

        Sortingpt2.sort(a,"teamname");

        for (Team team : a) {
            System.out.println(team.getTeamName() + " : " + team.getPpg22());
        }

    }
    
}
