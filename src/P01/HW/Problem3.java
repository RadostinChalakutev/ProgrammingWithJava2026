package P01.HW;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

     class Manager {
        String name;
        LocalDate hiringDate;

        Manager(String name) {
            this.name = name;
            this.hiringDate = LocalDate.of(2020, 1, 1);
        }

        String getName() {
            return name;

        }

        LocalDate getHiringDate() {
            return hiringDate;
        }

        void setHiringDate(LocalDate date) {
            LocalDate today = LocalDate.now();
            if (date.isAfter(today)) {
                this.hiringDate = LocalDate.of(2020, 1, 1);

            }
        }

        long numberOfYearInCompanyTill(LocalDate date) {
            if (date.isBefore(hiringDate)) {
                return 0;

            }
            return ChronoUnit.YEARS.between(hiringDate, date);

        }

    }

public class Problem3 {
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String name=sc.nextLine();

        int yearOfHiring=Integer.parseInt(sc.nextLine());
        int monthOFHiring=Integer.parseInt(sc.nextLine());
        int dayOfHiring=Integer.parseInt(sc.nextLine());

        int currentYear=Integer.parseInt(sc.nextLine());
        int currentMonth=Integer.parseInt(sc.nextLine());
        int currentDay=Integer.parseInt(sc.nextLine());


        Manager m=new Manager(name);
        m.setHiringDate(LocalDate.of(yearOfHiring,monthOFHiring,dayOfHiring));
        LocalDate current=LocalDate.of(currentYear,currentMonth,currentDay);

        System.out.println(yearOfHiring+"-"+monthOFHiring+"-"+dayOfHiring);
        System.out.println(m.numberOfYearInCompanyTill(current));
    }
}

