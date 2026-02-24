package Homework2;

import java.util.Random;

public class LabUtils {
    public static LaboratoryItem findMaxHazard(LaboratoryItem[] items) {
        LaboratoryItem maxItem = items[0];
        int maxLevel = items[0].getBiohazardLevel();
        for (int i = 1; i < items.length; i++) {
            if (items[i] != null && items[i].getBiohazardLevel() > maxLevel) {
                maxLevel = items[i].getBiohazardLevel();
                maxItem = items[i];
                if (maxLevel == 10) {
                    return maxItem;
                }
            }
        }
        return maxItem;
    }

    public static void shuffleArray(Object[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            Object temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    public static boolean compare(ResearchHub<?> first, ResearchHub<?> second) {
        return first.getClass() == second.getClass();
    }

    public static void generateReport(LaboratoryItem[] items) {
        for (LaboratoryItem item : items) {
            if (item != null) {
                System.out.println("class: [" + item.getClass() + "] ID: " + item.getSessionID()
                        + " | name: " + item.getSerialNumber());
            }
        }
    }
}