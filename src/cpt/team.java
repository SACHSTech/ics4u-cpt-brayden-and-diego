package cpt;

public class team {
    protected String teamName;
    protected double ppg22;
    protected double ppg21;
    protected double pct22;
    protected double pct21;
    protected double assists22;
    protected double assists21;
    protected double tpg22;
    protected double tpg21;
    protected double trg22;
    protected double trg21;

    public team(String teamName, double ppg22, double ppg21,double pct22,double pct21, double assists22, double assists21,double tpg22, double tpg21, double trg22, double trg12 ){
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
    
    public double getPpg22() {
        return ppg22;
    }
    
    public double getPpg21() {
        return ppg21;
    }
    
    public double getPct22() {
        return pct22;
    }
    
    public double getPct21() {
        return pct21;
    }
    
    public double getAssists22() {
        return assists22;
    }
    
    public double getAssists21() {
        return assists21;
    }
    
    public double getTpg22() {
        return tpg22;
    }
    
    public double getTpg21() {
        return tpg21;
    }
    
    public double getTrg22() {
        return trg22;
    }
    
    public double getTrg21() {
        return trg21;
    }



}
