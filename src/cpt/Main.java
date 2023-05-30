package cpt;

public class Main {
    public static void main(String[] args) {
        Team[] a = readFile.readDataFile("/Users/diegoverdin/github-classroom/SACHSTech/ics4u-cpt-brayden-and-diego/src/cpt/Comp Sci CPT spreadsheet - Points Per Game.csv");
        for (Team team : a) {
            System.out.println(team.getTeamName());
        }
    }
    
}
