package P01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class P07 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long x = Math.abs(n);
        if (x == 0) return; // 0 има безкрайно много делители

        // Събираме делителите (без самото число) и после ги сортираме
        ArrayList<Long> divisors = new ArrayList<>();

        for (long d = 1; d * d <= x; d++) {
            if (x % d == 0) {
                long a = d;
                long b = x / d;

                if (a != x) {
                    divisors.add(a);
                }
                if (b != a && b != x) divisors.add(b);
            }
        }

        Collections.sort(divisors);

        for (long d : divisors) {
            System.out.print(d + " ");
        }
    }
}

