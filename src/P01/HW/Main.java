package P01.HW;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine();
        int yearOfHiring = Integer.parseInt(sc.nextLine());
        int monthOFHiring = Integer.parseInt(sc.nextLine());
        int dayOfHiring = Integer.parseInt(sc.nextLine());

        int currentYear = Integer.parseInt(sc.nextLine());
        int currentMonth = Integer.parseInt(sc.nextLine());
        int currentDay = Integer.parseInt(sc.nextLine());


        Manager m = new Manager(name);
        LocalDate inputHire = LocalDate.of(yearOfHiring, monthOFHiring, dayOfHiring);
        m.setHiringDate(inputHire);

        LocalDate current = LocalDate.of(currentYear, currentMonth, currentDay);

        LocalDate hireToPrint = m.getHiringDate();
        System.out.printf("%04d-%02d-%02d%n", hireToPrint.getYear(), hireToPrint.getMonthValue(), hireToPrint.getDayOfMonth());
        System.out.println(m.numberOfYearsInCompanyTill(current));
    }
}
