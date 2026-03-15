

import java.util.Scanner;

class Manufacturer{
    private String name;
    private boolean warranty;

    Manufacturer(String name,boolean warranty){
        this.name=name;
        this.warranty=warranty;
    }
    public boolean hasExtendedWaranty(){
        return warranty;
    }
}
class ElectricDevice{
    protected Manufacturer manufacturer;
    protected int minimalWarranty;

    public ElectricDevice(Manufacturer manufacturer,int minimalWarranty){
        this.manufacturer=manufacturer;

        if (minimalWarranty >= 6) {
            this.minimalWarranty=minimalWarranty;
        }else {
            this.minimalWarranty = 6;
        }
    }
    public int warranty(){
        if (manufacturer.hasExtendedWaranty()) {

            return minimalWarranty+12;
        }
        return minimalWarranty;
    }
}
class Cooker extends ElectricDevice{
    private boolean isGas;

    Cooker(Manufacturer manufacturer,int minimalWarranty,boolean isGas){
        super(manufacturer,minimalWarranty);
        this.isGas=isGas;
    }
    @Override
    public int warranty(){
        int result=super.warranty();
        if (isGas) {

            result+=12;
        }
        return result;
    }
}
class WashingMachine extends ElectricDevice{
    private boolean hasDryFunction;

    WashingMachine(Manufacturer manufacturer,int minimalWarranty, boolean isDryFunction){
        super(manufacturer,minimalWarranty);
        this.hasDryFunction=isDryFunction;
    }
    @Override
     public int warranty(){
        int result=super.warranty();
        if(hasDryFunction){
            result+=minimalWarranty/2;
        }
        return result;
    }
}
public class Task1{
    public static void main(String[]args) {
        Scanner scanner = new Scanner(System.in);

        String manufacturerName = scanner.nextLine();
        boolean extendedWarranty = scanner.nextInt() == 1;
        int minWarranty = scanner.nextInt();
        boolean isGas = scanner.nextInt() == 1;
        boolean hasDryFunction = scanner.nextInt() == 1;

        Manufacturer manufacturer = new Manufacturer(manufacturerName, extendedWarranty);
        ElectricDevice device = new ElectricDevice(manufacturer, minWarranty);
        System.out.println(device.warranty());
        device=new Cooker(manufacturer,minWarranty,isGas);
        System.out.println(device.warranty());
        device=new WashingMachine(manufacturer,minWarranty,hasDryFunction);
        System.out.println(device.warranty());
    }
}


