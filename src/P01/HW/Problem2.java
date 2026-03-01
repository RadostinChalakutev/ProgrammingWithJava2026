package P01.HW;

import java.util.Scanner;

public class Problem2
{

    public static long sequenceSum(int size) {
        if (size < 1 || size > 9) return 0;

        long total = 0;
        for (int k = 0; k <= size - 1; k++) {
            long sumToSize = (long) size * (size + 1) / 2;
            long sumToK = (long) k * (k + 1) / 2;
            long row = 2L * (sumToSize - sumToK);

            if (k == size - 1) total += row;
            else total += 2L * row;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) {
            System.out.println(0);
            return;
        }
        int size = sc.nextInt();
        System.out.println(sequenceSum(size));
    }
}
