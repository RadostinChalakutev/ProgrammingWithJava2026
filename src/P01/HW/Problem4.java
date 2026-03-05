package P01.HW;

import java.math.BigDecimal;

class Studio{
    private int id;
    private BigDecimal priceInLvPerHour;
    private int maxHours;
    private int hoursLoan;
    private int minimalHours;
    private BigDecimal courseEuro;

    public Studio(int id, int maxHours, int minPricePerHour1, BigDecimal currencyEuro1, BigDecimal pricePerHour1, int workedHour1){
        this.id=id;
        this.maxHours=maxHours;
    }
    public void setMinimalHours(int minimalHours){
        this.minimalHours=minimalHours;

    }
    public void setPriceInLvPerHour(BigDecimal priceInLvPerHour){
        if(hoursLoan>24){
            return;
        }else{
            this.priceInLvPerHour=priceInLvPerHour;
        }
    }
    public void setCourseEuro(BigDecimal courseEuro){
        this.courseEuro=courseEuro;
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

    public int getMinimalHours() {
        return minimalHours;
    }
    public void setHoursLoan(int hoursLoan){
        if(hoursLoan<=0){
            return;
        }
        if(hoursLoan>maxHours)return;
        if(minimalHours>0&&hoursLoan<minimalHours)return;
        this.hoursLoan=hoursLoan;
    }
    public BigDecimal turnoverInLv(){
     if(hoursLoan<=0){
         return BigDecimal.ZERO;
     }
     return priceInLvPerHour.multiply(BigDecimal.valueOf(hoursLoan));
    }

    public BigDecimal turnoverInEuro(){
        if(hoursLoan<=0){
            return BigDecimal.ZERO;

        }
        return turnoverInLv().multiply(getCourseEuro());
    }
    public Studio compareByPrice(Studio other){
        return( this.priceInLvPerHour.compareTo(other.priceInLvPerHour)>=0)?this:other;

    }
    public boolean hasBiggerTurnover(Studio other){
        return this.turnoverInLv().compareTo(other.turnoverInLv())>0;
    }

}
