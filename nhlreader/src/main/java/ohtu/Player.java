
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private Integer assists;
    private Integer goals;
    private Integer penalties;
    private String team;
    private Integer games;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
        public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getAssists() {
        return assists;
    }

    public void setAssists(Integer assists) {
        this.assists = assists;
    }

    public Integer getGoals() {
        return goals;
    }

    public void setGoals(Integer goals) {
        this.goals = goals;
    }

    public Integer getPenalties() {
        return penalties;
    }

    public void setPenalties(Integer penalties) {
        this.penalties = penalties;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getTotalPoints() {
        return this.goals + this.assists;
    }
    
    @Override
    public String toString() {
        return name + "\t\t" + this.team + "\t" + this.goals + " + " + this.assists + " = " + this.getTotalPoints() ;
    }
      
}
