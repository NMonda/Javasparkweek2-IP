package ke.co.pookie;

import java.time.LocalDateTime;

public class Squad {
    private int id;
    private String squadName;
    private String cause;
    private int maxSize;
    private LocalDateTime createdAt;

    public Squad(int id, String squadName, String cause, int maxSize, LocalDateTime createdAt) {
        this.id = id;
        this.squadName = squadName;
        this.cause = cause;
        this.maxSize = maxSize;
        this.createdAt = createdAt;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
