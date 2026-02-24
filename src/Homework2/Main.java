package Homework2;

import Classwork1.Fraction;

public class Main {
    public static void main(String[] args) {
        //сценарий 1
        ResearchHub<ResearchSample<Double>> array = new ResearchHub<>();
        MedicalDevice device = new MedicalDevice(null, 0, null, null, 0);
        //array.register(device);
        //ошибка компиляции - нельзя привести MedicalDevice к ResearchSample<Double>, он не является подтипом этого класса

        //сценарий 2
        ResearchHub<LaboratoryItem> array1 = new ResearchHub<>();
        ResearchSample<Double> sample1 = new ResearchSample<>("101", 1, 1, "вода", 0.95);
        ResearchSample<Integer> sample2 = new ResearchSample<>("102", 5, 2, "кислота", 100);
        MedicalDevice device1 = new MedicalDevice("201", 2, 3, "центрифуга", 0.121);
        array1.register(sample1);
        array1.register(sample2);
        array1.register(device1);
        System.out.println("элементов до: " + array1.getCount());
        array1.release(1);
        System.out.println("элементов после: " + array1.getCount());
        LabUtils.generateReport(array1.getStorage());

        //сценарий 3
        ResearchHub<LaboratoryItem> array2 = new ResearchHub<>();
        ResearchSample<Double> sample3 = new ResearchSample<>("103", 2, 4, "вода", 0.5);
        ResearchSample<Integer> sample4 = new ResearchSample<>("104", 5, 5, "кислота", 50);
        ResearchSample<Fraction> sample5 = new ResearchSample<>("105", 3, 6, "кефир", new Fraction(1, 2));
        array2.register(sample3);
        array2.register(sample4);
        array2.register(sample5);
        array2.adjustPurity(10, 0.5);
        System.out.println("средняя чистота: " + array2.getAveragePurity());

        //сценарий 4
        ResearchHub<LaboratoryItem> array3 = new ResearchHub<>();
        ResearchSample<Double> sample6 = new ResearchSample<>("106", 1, 100, "вода", 0.66666);
        System.out.println("проверка 100: " + array3.checkSession(sample6, 100));
        ResearchSample<Integer> sample7 = new ResearchSample<>("107", 7, 250, "кислота", 99);
        System.out.println("проверка 250: " + array3.checkSession(sample7, 250));
        // числа от -128 до 127 кэшируются, поэтому при сравнении через == для 100 получаем true (один объект), а
        // 250 не попадает в диапазон кэширования, создаются новые объекты

        //сценарий 5
        LaboratoryItem[] items = new LaboratoryItem[5];
        items[0] = new ResearchSample<Double>("108", 1, 7, "вода", 0.99);
        items[1] = new ResearchSample<Integer>("109", 9, 8, "кислота", 65);
        items[2] = new ResearchSample<Double>("110", 2, 9, "молоко", 0.25);
        items[3] = new ResearchSample<Integer>("111", 10, 10, "спирт", 85);
        items[4] = new ResearchSample<Double>("112", 6, 11, "соль", 0.75);

        System.out.println("максимальная опасность: " + LabUtils.findMaxHazard(items));
        ResearchHub<LaboratoryItem> hub1 = new ResearchHub<>();
        for (LaboratoryItem item : items) {
            hub1.register(item);
        }
        hub1.clearByHazardLevel(5);
        LabUtils.generateReport(hub1.getStorage());

        ResearchHub<MedicalDevice> hub2 = new ResearchHub<>();
        MedicalDevice device2 = new MedicalDevice("202", 1, 12, "микроскоп", 0.01);
        hub2.register(device2);
        System.out.println("одинаковые? " + LabUtils.compare(hub1, hub2));
    }
}