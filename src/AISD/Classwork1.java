package AISD;

import java.util.Scanner;

public class Classwork1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int mod = a % m;
        int sum = 1;
        while (n > 0) {
            if (n % 2 == 1) {
                sum = (sum * mod) % m;
            }
            mod = (mod * mod) % m;
            n = n / 2;
        }
        System.out.println(sum);
    }
}
