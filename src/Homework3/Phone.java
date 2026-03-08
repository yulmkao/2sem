package Homework3;

public class Phone extends Electronics {
    private int storageGB;

    public Phone(String name, int storageGB) {
        super(name);
        this.storageGB = storageGB;
    }

    public Phone(String name) {
        super(name);
    }

    public int getStorageGB() {
        return storageGB;
    }
}