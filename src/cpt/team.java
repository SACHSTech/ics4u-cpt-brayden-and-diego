package cpt;



public class Team {
 
    protected String teamName;
    protected String ppg22;
    protected String ppg21;
    protected String pct22;
    protected String pct21;
    protected String assists22;
    protected String assists21;
    protected String tpg22;
    protected String tpg21;
    protected String trg22;
    protected String trg21;
    protected String name;


    /**
     * this is an object of type team it will sort all the statistics associated with a given team
     * @param teamName: name
     * @param ppg22: points per game 2022
     * @param ppg21: point per game 2021
     * @param pct22: 3 point percentage 2022
     * @param pct21: 3 point percentage 2021
     * @param assists22: assits in 2022
     * @param assists21: assists in 2021
     * @param tpg22: turnovers per game 2022
     * @param tpg21: turnovers per game 2021
     * @param trg22: total reboubnd per game 2022
     * @param trg21: total rebound per game 2021
     */
    public Team(String teamName, String ppg22, String ppg21,String pct22,String pct21, String assists22, String assists21,String tpg22, String tpg21, String trg22, String trg21 ){
        this.teamName = teamName;
        this.ppg22 = ppg22;
        this.ppg21 = ppg21;
        this.pct22 = pct22;
        this.pct21 = pct21;
        this.assists22 = assists22;
        this.assists21 = assists21;
        this.tpg22 = tpg22;
        this.tpg21 = tpg21;
        this.trg22 = trg22;
        this.trg21 = trg21;

    }

    //getter functions
    public String getTeamName() {
        return teamName;
    }
    
    public String getPpg22() {
        return ppg22;
    }
    
    public String getPpg21() {
        return ppg21;
    }
    
    public String getPct22() {
        return pct22;
    }
    
    public String getPct21() {
        return pct21;
    }
    
    public String getAssists22() {
        return assists22;
    }
    
    public String getAssists21() {
        return assists21;
    }
    
    public String getTpg22() {
        return tpg22;
    }
    
    public String getTpg21() {
        return tpg21;
    }
    
    public String getTrg22() {
        return trg22;
    }
    
    public String getTrg21() {
        return trg21;
    }
    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

   



}


