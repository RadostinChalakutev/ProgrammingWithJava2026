package P01.HW;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

class Manager {
    private String name;
    private LocalDate hireDate;

    public Manager(String name) {
        this.name = name;
        this.hireDate = LocalDate.of(2020, 1, 1);
    }

    public String getName() {
        return name;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        if (hireDate == null) {
            this.hireDate = LocalDate.of(2020, 1, 1);
            return;
        }
        LocalDate today = LocalDate.now();
        if (hireDate.isAfter(today)) {
            this.hireDate = LocalDate.of(2020, 1, 1);
        } else {
            this.hireDate = hireDate;
        }
    }

    public long numberOfYearsInCompanyTill(LocalDate tillDate) {
        if (hireDate == null || tillDate == null) return 0;
        if (tillDate.isBefore(hireDate)) return 0;
        return Period.between(hireDate, tillDate).getYears();
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name = sc.nextLine().trim();

        int hy = Integer.parseInt(sc.nextLine().trim());
        int hm = Integer.parseInt(sc.nextLine().trim());
        int hd = Integer.parseInt(sc.nextLine().trim());

        int cy = Integer.parseInt(sc.nextLine().trim());
        int cm = Integer.parseInt(sc.nextLine().trim());
        int cd = Integer.parseInt(sc.nextLine().trim());

        Manager m = new Manager(name);
        m.setHireDate(LocalDate.of(hy, hm, hd));

        LocalDate currentDate = LocalDate.of(cy, cm, cd);

        System.out.println(m.getHireDate());
        System.out.println(m.numberOfYearsInCompanyTill(currentDate));
    }
}