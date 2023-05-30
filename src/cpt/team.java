package cpt;

public class team {
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

    public team(String teamName, String ppg22, String ppg21,String pct22,String pct21, String assists22, String assists21,String tpg22, String tpg21, String trg22, String trg21 ){
        teamName = this.teamName;
        ppg22 = this.ppg22;
        ppg21 = this.ppg21;
        pct22 = this.pct22;
        pct21 = this.pct21;
        assists22 = this.assists22;
        assists21 = this.assists21;
        tpg22 = this.tpg22;
        tpg21 = this.tpg21;
        trg22 = this.trg22;
        trg21 = this.trg21;

    }


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



}
