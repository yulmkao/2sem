package Homework3;

public class CustomsTerminal {
    public static void inspectCargo(CargoBay<? extends Cargo> bay) {
        for (int i = 0; i < bay.getSize(); i++) {
            Cargo cargo = bay.get(i);
            if (cargo != null) {
                System.out.println(cargo.getName());
            }
        }
    }

    public static void loadHumanitarianApples(CargoBay<? super Fruit> bay) {
        for (int i = 0; i < 10; i++) {
            bay.add(new Fruit("яблоко" + i));
        }
    }

    public static <T> void transferCargo(CargoBay<? extends T> source, CargoBay<? super T> getter) {
        for (int i = 0; i < source.getSize(); i++) {
            T item = source.get(i);
            getter.add(item);
        }
    }
}
