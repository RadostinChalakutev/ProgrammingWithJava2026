package P01;

import java.util.*;

public class P06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long x = Math.abs(n);
        if (x == 0) {                 // 0 има безкрайно много делители
            System.out.print(0);
            return;
        }

        long sum = 0;

        for (long d = 1; d * d <= x; d++) {
            if (x % d == 0) {
                long a = d;
                long b = x / d;

                if (a != x) sum += a;                 // добавяме d
                if (b != a && b != x) sum += b;       // добавяме x/d (ако е различен и не е самото число)
            }
        }

        System.out.print(sum);
    }
}