package P03.HW;

import java.util.Locale;
import java.util.Scanner;

interface Deliverable{
    double deliveryPrice();
}
abstract class DeliverableItem implements Deliverable{
    protected boolean toAdress;
    protected static double aditionalPrice=1;

    public DeliverableItem(boolean toAdress){
        this.toAdress=toAdress;
    }
    public static void setAditionalPrice(double aditionalPrice){
        if(aditionalPrice>0){
            DeliverableItem.aditionalPrice=aditionalPrice;
        }else{
            DeliverableItem.aditionalPrice=1;
        }
    }
    @Override
    public double deliveryPrice(){
        return toAdress? aditionalPrice:0;
    }
}
class Material{
    String name;
    boolean fragile;

    public Material(String name,boolean fragile){
        this.name=name;
        this.fragile=fragile;
    }
    public boolean isFragile(){
        return fragile;
    }
}
class Document extends DeliverableItem{
    private double minPrice;

    public Document(boolean toAdress, double minPrice){
        super(toAdress);
        if(minPrice>0){
            this.minPrice=minPrice;
        }else{
            this.minPrice=1;
        }
    }
    @Override
    public double deliveryPrice(){
        if(toAdress){
            return minPrice+aditionalPrice;
        }
        return minPrice;
    }
}
class WeightedItem extends DeliverableItem{
    private Material material;
    private double weight;
    private double pricePerKg;

    public WeightedItem(boolean toAdress, Material material, double weight, double pricePerKg){
        super(toAdress);
        this.material=material;
        this.weight=weight>0?weight:1;
        this.pricePerKg=pricePerKg>0?pricePerKg:1;
    }
    @Override
    public double deliveryPrice(){
        double price=weight*pricePerKg;
        if(toAdress){
            price+=aditionalPrice;
        }
        if(material.isFragile()){
            price*=1.01;
        }
        return price;
    }
}
public class Task1{
    static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        String materialName=scanner.nextLine();
        boolean fragile=scanner.nextInt()==1;
        boolean toAddress=scanner.nextInt()==1;
        double minPrice= scanner.nextDouble();
        double weight=scanner.nextDouble();
        double pricePerKg=scanner.nextDouble();
        double aditionalPrice=scanner.nextDouble();

        Material material=new Material(materialName,fragile);
        DeliverableItem.setAditionalPrice(aditionalPrice);
        Deliverable d;

        d=new Document(toAddress,minPrice);
        System.out.printf("%.1f%n",d.deliveryPrice());

        d=new WeightedItem(toAddress,material,weight,pricePerKg);
        System.out.printf("%.2f%n",d.deliveryPrice());
    }
}