package ke.co.pookie;

public class Squad {
    private int id;
    private String squadName;
    private String cause;
    private int maxSize;


    public Squad(int id, String squadName, String cause, int maxSize) {
        this.id = id;
        this.squadName = squadName;
        this.cause = cause;
        this.maxSize = maxSize;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSquadName() {
        return squadName;
    }

    public void setSquadName(String squadName) {
        this.squadName = squadName;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }


}