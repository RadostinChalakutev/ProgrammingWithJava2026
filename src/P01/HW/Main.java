package P01.HW;

import java.math.BigDecimal;
import java.util.Scanner;

class Studio{
    private final int id;
    private BigDecimal priceInLvPerHour=BigDecimal.ZERO;
    private final int maxHours;
    private int hoursLoan;
    private static BigDecimal minimalPricePerHour=BigDecimal.ZERO;
    private static BigDecimal courseEuro=BigDecimal.ZERO;

    public Studio(int id, int maxHours, int minPricePerHour1, BigDecimal currencyEuro1, BigDecimal pricePerHour1, int workedHour1){
        this.id=id;
        if(maxHours<0||maxHours>24){
            this.maxHours=24;
        }else{
            this.maxHours=maxHours;
        }

    }

    public static void setMinimalPricePerHour(BigDecimal minPrice){
        if(minPrice==null||minPrice.compareTo(BigDecimal.ZERO)>0){
            minimalPricePerHour=BigDecimal.ZERO;
        }else{
            minimalPricePerHour=minPrice;
        }
    }
    public void setPriceInLvPerHour(BigDecimal priceInLvPerHour){
        if(priceInLvPerHour==null)return;

        if(priceInLvPerHour.compareTo(minimalPricePerHour)<0){
            this.priceInLvPerHour=minimalPricePerHour;
        }else{
            this.priceInLvPerHour=priceInLvPerHour;
        }
    }
    public static void setCourseEuro(BigDecimal courseEuroParam){
        if (courseEuroParam!=null){
            courseEuro=courseEuroParam;
        }
    }

    public BigDecimal getCourseEuro() {
        return courseEuro;
    }

    public BigDecimal getPriceInLvPerHour() {
        return priceInLvPerHour;
    }

    public int getHoursLoan() {
        return hoursLoan;
    }

    public int getId() {
        return id;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public static BigDecimal getMinimalPricePerHour() {
        return minimalPricePerHour;
    }

    public void setHoursLoan(int hoursLoan){
        if(hoursLoan<0){
            this.hoursLoan=0;
        }else if(hoursLoan>maxHours){
            this.hoursLoan=maxHours;
        }else{
            this.hoursLoan=hoursLoan;
        }
    }
    public BigDecimal turnoverInLv(){

        return priceInLvPerHour.multiply(BigDecimal.valueOf(hoursLoan));
    }

    public BigDecimal turnoverInEuro(){

        return turnoverInLv().multiply(courseEuro);
    }
    public Studio compareByPrice(Studio other){
        return( this.priceInLvPerHour.compareTo(other.priceInLvPerHour)>=0)?this:other;

    }
    public boolean hasBiggerTurnover(Studio other){
        return this.turnoverInLv().compareTo(other.turnoverInLv())>0;
    }

}

public class Main {

    static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int id1 = Integer.parseInt(scanner.nextLine());
        int maxWorkingHour1 = Integer.parseInt(scanner.nextLine());
        int minPricePerHour1 = Integer.parseInt(scanner.nextLine());
      String s =scanner.nextLine();
      BigDecimal currencyEuro1= new BigDecimal(s);
      String d=scanner.nextLine();
      BigDecimal pricePerHour1=new BigDecimal(d);
        int workedHour1 = Integer.parseInt(scanner.nextLine());

        Studio studio1 = new Studio(id1, maxWorkingHour1, minPricePerHour1, currencyEuro1, pricePerHour1, workedHour1);

        int id2 = Integer.parseInt(scanner.nextLine());
        int maxWorkingHour2 = Integer.parseInt(scanner.nextLine());
        int minPricePerHour = Integer.parseInt(scanner.nextLine());

        int workedHour2 = Integer.parseInt(scanner.nextLine());
        Studio studio2=new Studio(id2,maxWorkingHour2,minPricePerHour,currencyEuro1,pricePerHour1,workedHour2);


        System.out.println(studio1.turnoverInLv());
        System.out.println(studio1.turnoverInLv());
        Studio moreExpensive=studio1.compareByPrice(studio2);
        System.out.println(moreExpensive.getId());
        System.out.println(studio1.hasBiggerTurnover(studio2));


    }
}
