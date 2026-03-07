
import java.math.BigDecimal;
import java.util.Scanner;

class Studio {
    private final int id;
    private BigDecimal priceInLvPerHour = BigDecimal.ZERO;
    private int maxHours;
    private int hoursLoan;

    private static BigDecimal minimalPricePerHour = BigDecimal.ZERO;

    private static BigDecimal courseEuro = BigDecimal.ONE;

    public Studio(int id, int maxHours) {
        this.id = id;
        if (maxHours < 0 || maxHours > 24) {
            this.maxHours = 24;
        } else {
            this.maxHours = maxHours;
        }
    }

    public static void setMinimalPricePerHour(BigDecimal minPrice) {
        if (minPrice == null || minPrice.compareTo(BigDecimal.ZERO) < 0) {
            minimalPricePerHour = BigDecimal.ZERO;
        } else {
            minimalPricePerHour = minPrice;
        }
    }

    public void setPriceInLvPerHour(BigDecimal priceInLvPerHour) {
        if (priceInLvPerHour == null) return;

        if (priceInLvPerHour.compareTo(minimalPricePerHour) < 0) {
            this.priceInLvPerHour = minimalPricePerHour;
        } else {
            this.priceInLvPerHour = priceInLvPerHour;
        }
    }

    public void setHoursLoan(int hoursLoan) {
        if (hoursLoan < 0) {
            this.hoursLoan = 0;
        } else if (hoursLoan > maxHours) {
            this.hoursLoan = maxHours;
        } else {
            this.hoursLoan = hoursLoan;
        }
    }

    public static void setCourseEuro(BigDecimal courseEuroParam) {
        if (courseEuroParam != null) {
            courseEuro = courseEuroParam;
        }
    }

    public BigDecimal turnoverInLvForTheDay() {
        return priceInLvPerHour.multiply(BigDecimal.valueOf(hoursLoan));
    }

    public BigDecimal turnoverInEuroForTheDay() {
        return turnoverInLvForTheDay().multiply(courseEuro);
    }

    public Studio compareByPricePerHour(Studio other) {
        return (this.priceInLvPerHour.compareTo(other.priceInLvPerHour) > 0) ? this : other;
    }

    public boolean hasBiggerTurnoverThan(Studio other) {
        return this.turnoverInLvForTheDay().compareTo(other.turnoverInLvForTheDay()) > 0;
    }

    public int getId() { return id; }
    public BigDecimal getPriceInLvPerHour() { return priceInLvPerHour; }
    public int getMaxHours() { return maxHours; }
    public int getHoursLoan() { return hoursLoan; }
    public static BigDecimal getMinimalPricePerHour() { return minimalPricePerHour; }
    public static BigDecimal getCourseEuro() { return courseEuro; }
}

public class Solution {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int id1 = Integer.parseInt(scanner.nextLine());
        int maxWorkingHour1 = Integer.parseInt(scanner.nextLine());
        String r=scanner.nextLine();
        BigDecimal minPricePerHour=new BigDecimal(r);

        Studio.setMinimalPricePerHour(minPricePerHour);
        String s = scanner.nextLine();
        BigDecimal currencyEuro1 = new BigDecimal(s);
        Studio.setCourseEuro(currencyEuro1);

        String d = scanner.nextLine();
        BigDecimal pricePerHour1 = new BigDecimal(d);
        int workedHour1 = Integer.parseInt(scanner.nextLine());

        Studio studio1 = new Studio(id1,maxWorkingHour1);
        studio1.setPriceInLvPerHour(pricePerHour1);
        studio1.setHoursLoan(workedHour1);

        int id2 = Integer.parseInt(scanner.nextLine());
        int maxWorkingHour2 = Integer.parseInt(scanner.nextLine());
        String x=scanner.nextLine();
        BigDecimal pricePerHour=new BigDecimal(x);
        int workedHour2 = Integer.parseInt(scanner.nextLine());
        Studio studio2 = new Studio(id2, maxWorkingHour2);
        studio2.setPriceInLvPerHour(pricePerHour);
        studio2.setHoursLoan(workedHour2);

       System.out.printf("%.1f",studio1.turnoverInLvForTheDay());
       System.out.println();
       System.out.printf("%.3f",studio1.turnoverInEuroForTheDay());
       System.out.println();
        Studio moreExpensive=studio1.compareByPricePerHour(studio2);
        System.out.println(moreExpensive.getId());
        System.out.println(studio1.hasBiggerTurnoverThan(studio2));

    }
}
