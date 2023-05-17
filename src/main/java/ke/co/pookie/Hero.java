package ke.co.pookie;

public class Hero {
    private int id;
    private String heroName;
    private String power;
    private String weakness;
    private int squadId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public int getSquadId() {
        return squadId;
    }

    public void setSquadId(int squadId) {
        this.squadId = squadId;
    }

    public Hero(int id, String name, String power, String weakness, int squadId) {
        this.id = id;
        this.heroName = name;
        this.power = power;
        this.weakness = weakness;
        this.squadId = squadId;
    }
}
