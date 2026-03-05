package P01.HW;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int id1 = Integer.parseInt(scanner.nextLine());
        int maxWorkingHour1 = Integer.parseInt(scanner.nextLine());
        int minHours1 = Integer.parseInt(scanner.nextLine());
        BigDecimal currencyEuro1 = scanner.nextBigDecimal();
        double  pricePerHour1 =Double.parseDouble(scanner.nextLine());;
        int workedHour1 = Integer.parseInt(scanner.nextLine());
        Studio studio1 = new Studio(id1, maxWorkingHour1, minHours1, currencyEuro1, pricePerHour1, workedHour1);
        int id2 = Integer.parseInt(scanner.nextLine());
        int maxWorkingHour2 = Integer.parseInt(scanner.nextLine());
        int minHours2 = Integer.parseInt(scanner.nextLine());
        BigDecimal currencyEuro2 = scanner.nextBigDecimal();
        BigDecimal pricePerHour2 = scanner.nextBigDecimal();
        int workedHour2 = Integer.parseInt(scanner.nextLine());
        Studio studio2=new Studio(id2,maxWorkingHour2,minHours2,currencyEuro2,pricePerHour2,workedHour2);

        System.out.println(studio1.turnoverInLv());
        System.out.println(studio1.turnoverInEuro());
        Studio moreExpensive=studio1.compareByPrice(studio2);
        System.out.println(moreExpensive.getId());

        System.out.println(studio1.hasBiggerTurnover(studio2));


    }
}
