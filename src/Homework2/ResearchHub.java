package Homework2;

public class ResearchHub<T extends LaboratoryItem> {
    private T[] storage;
    private int count;

    public ResearchHub() {
        storage = (T[]) new LaboratoryItem[2];
        count = 0;
    }

    public int getCount() {
        return count;
    }

    public T[] getStorage() {
        return storage;
    }

    public void register(T item) {
        if (count == storage.length) {
            T[] newStorage = (T[]) new LaboratoryItem[storage.length * 2];
            for (int i = 0; i < storage.length; i++) {
                newStorage[i] = storage[i];
            }
            storage = newStorage;
        }
        storage[count] = item;
        count++;
    }

    public void release(int index) {
        T[] newStorage = (T[]) new LaboratoryItem[count - 1];
        for (int i = 0; i < index; i++) {
            newStorage[i] = storage[i];
        }
        for (int i = index + 1; i < count; i++) {
            newStorage[i - 1] = storage[i];
        }
        storage = newStorage;
        count--;
    }

    public int indexOf(T item) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void clearByHazardLevel(int limit) {
        for (int i = count - 1; i >= 0; i--) {
            if (storage[i].getBiohazardLevel() > limit) {
                release(i);
            }
        }
    }

    public void adjustPurity(Number offset, Number multiplier) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] instanceof ResearchSample) {
                ResearchSample sample = (ResearchSample) storage[i];
                double newPurity = (sample.getPurity().doubleValue() + offset.doubleValue()) * multiplier.doubleValue();
                sample.setPurity(newPurity);
            }
        }
    }

    public double getAveragePurity() {
        double sum = 0;
        int counter = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] instanceof ResearchSample) {
                ResearchSample sample = (ResearchSample) storage[i];
                sum += sample.getPurity().doubleValue();
                counter++;
            }
        }
        return sum / counter;
    }

    public boolean checkSession(T item, Integer sessionID) {
        return item.getSessionID() == sessionID;
    }
}