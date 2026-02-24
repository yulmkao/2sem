package Homework2;

public abstract class LaboratoryItem {
    private String serialNumber;
    private int biohazardLevel;
    private Integer sessionID;

    public LaboratoryItem(String serialNumber, int biohazardLevel, Integer sessionID) {
        this.serialNumber = serialNumber;
        this.biohazardLevel = biohazardLevel;
        if (biohazardLevel < 0 && biohazardLevel > 10){
            throw new IllegalArgumentException("таких измерений нет");
        }
        this.sessionID = sessionID;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public int getBiohazardLevel() {
        return biohazardLevel;
    }

    public Integer getSessionID() {
        return sessionID;
    }

    public void setSessionID(Integer sessionID) {
        this.sessionID = sessionID;
    }
}