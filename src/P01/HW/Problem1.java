package P01.HW;

import java.util.Scanner;

public class Problem1{
    public static long countRotatedIncrease(long bottom, long top, long difference) {
        if (bottom < 0 || top < 0 || bottom > top) return 0;

        long count = 0;
        for (long n = bottom; n <= top; n++) {
            long rotated = rotateFirstDigitToEnd(n);
            if (rotated - n > difference) {
                count++;
            }
        }        return count;
    }


    private static long rotateFirstDigitToEnd(long n) {
        if (n < 10) return n;

        long pow10 = 1;
        while (n / pow10 >= 10) {
            pow10 *= 10;
        }

        long firstDigit = n / pow10;
        long rest = n % pow10;

        return rest * 10 + firstDigit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);



        if (!sc.hasNextLong()) { System.out.println(0); return; }
        long bottom = sc.nextLong();

        if (!sc.hasNextLong()) { System.out.println(0); return; }
        long top = sc.nextLong();

        if (!sc.hasNextLong()) { System.out.println(0); return; }
        long difference = sc.nextLong();

        System.out.println(countRotatedIncrease(bottom, top, difference));
    }
}
