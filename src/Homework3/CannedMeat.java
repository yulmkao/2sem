package Homework3;

public class CannedMeat extends Food {
    private String meatType;

    public CannedMeat(String name, String meatType) {
        super(name);
        this.meatType = meatType;
    }

    public String getMeatType() {
        return meatType;
    }
}
