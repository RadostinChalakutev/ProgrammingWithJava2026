/* Да се състави програма, която при дадена година
 показва броя на дните в месеца. Необходимо е да се
 направи проверка дали годината е високосна или не.
Пример:
2020
February
Output: February is 29 days in 2020!*/

import java.util.Scanner;

public class P02 {
static boolean isLeapYear(int year){
    return (year%4==0);
}
    static void main() {
        Scanner scanner=new Scanner(System.in);
        int year=Integer.parseInt(scanner.nextLine().trim());
        String month=scanner.nextLine().trim();
        int days=-1;


        switch(month){
            case "January":
            case "March":
            case "May":
            case "July":
            case "August":
            case "Octomber":
            case "December":
                days=31;
                break;
            case "April":
            case "September":
            case "June":
            case "November":
                days=30;
                break;
            case "February":
                days=isLeapYear(year)?29:28;


        }
        System.out.println(month+" is "+days+" days in "+year);
    }

}