package P01;

import java.util.Scanner;

public class EvenNumbers {
    static void main() {
        Scanner scanner= new Scanner(System.in);

        int start=Integer.parseInt(scanner.nextLine());
        int end=Integer.parseInt(scanner.nextLine());

        for (int i = start; i <=end ; i++) {
            if(i%2==0){
                System.out.println(i);
            }
        }
    }
}
