package P01.HW;

import java.util.Scanner;

public class Main {

    public static int countNumbers(int bottom, int top, int difference) {

        if (bottom < 0 || top < 0 || bottom > top) return 0;

        int count = 0;

        for (int n = bottom; n <= top; n++) {

            String s = String.valueOf(n);


            if (s.length() == 1) continue;


            String rotatedStr = s.substring(1) + s.charAt(0);


            int rotated = Integer.parseInt(rotatedStr);

            if (rotated - n > difference) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int bottom = sc.nextInt();
        int top = sc.nextInt();
        int difference = sc.nextInt();

        System.out.println(countNumbers(bottom, top, difference));
    }
}