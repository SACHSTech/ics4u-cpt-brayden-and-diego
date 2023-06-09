package cpt;

public class Main {
    public static void main(String[] args) {
        Team[] a = readFile.readDataFile("C:/Users/stoic/Comp Sci Grade 12/ics4u-cpt-brayden-and-diego/src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv");
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
