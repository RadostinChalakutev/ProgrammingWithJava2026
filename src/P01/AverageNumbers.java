package P01;

import java.util.Scanner;

public class AverageNumbers {
    static void main() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        int sum = 0;
        int average = 0;
        int count = 0;
        for (int i = a; i <=b ; i++) {
            if(i%5==0&&i%3==1){
                sum+=i;
                count++;
            }

        }
        average=sum/count;
        System.out.println(average);


    }
}
