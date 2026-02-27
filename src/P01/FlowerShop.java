package P01;
import java.math.BigDecimal;

/**Създайте клас FlowersShop (магазин за цветя, в магазина се продават само един вид цветя) с член-данни:
 * брой на наличните цветя и цена за едно цвете. Създайте следните методи на класа:
 Конструктор без параметри, който създава магазин за цветя с 0 на брой цветя и 0 лв. единична цена на цвете.
 Конструктор с един параметър (брой цветя), единичната цена да бъде 0лв.
 Конструктор с един параметър (единична цена), броят на цветята да бъде 0.
 Конструктор с два параметъра (брой цветя и единична цена).
 */
public class FlowerShop {
    private int numberOfFlowers;
    private double price;

    public FlowerShop(){};

    public FlowerShop(int numberOfFlowers){
        this.numberOfFlowers=numberOfFlowers;
    }
    public FlowerShop(double price){
        this.price=price;
    }
    public FlowerShop(int numberOfFlowers,double price){
        this.numberOfFlowers=numberOfFlowers;
        this.price=price;
    }

    public int getNumberOfFlowers(){
        return numberOfFlowers;
    }
    public double getPrice(){
        return price;
    }
    public void setNumberOfFlowers(int numberOfFlowers){
        this.numberOfFlowers=numberOfFlowers;


    }
    public void setPrice(double price){
        this.price=price;
    }

    @Override
    public String toString(){

        return "Flower Shop with "+numberOfFlowers+" with price "+ price+"per flower";
    }
    public void increaseNumberOfFlowers(int numberOfFlowers){
        if (numberOfFlowers<0){
            System.out.println("Cannot increase flowers with negative numbers");

        }else{
            this.numberOfFlowers+=numberOfFlowers;
        }
    }

    public void decreaseNumberOfFlowers(int numberOfFlowers){
        if(numberOfFlowers<0){
            System.out.println("Cannot decrease number with negative number");

        } else if (this.numberOfFlowers<=numberOfFlowers) {
            this.numberOfFlowers=0;


        }else{
            this.numberOfFlowers-=numberOfFlowers;
        }
    }

    public void increasePrice(double price){
        if(price<0){
            System.out.println("Cannot increase flowers with negative numbers");


        }else if(!(this.price>0)){
            this.price=0;
        }else{
            this.price+=price;
        }
    }
    public double profit(){
        return price*numberOfFlowers;
    }
    public boolean isFirstMoreProfitable(FlowerShop flowerShop){
        if(this.profit()>flowerShop.profit()){
            return true;
        }else{
            return false;
        }
    }



}

