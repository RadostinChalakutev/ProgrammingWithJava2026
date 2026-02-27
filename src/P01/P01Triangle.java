package P01;

import java.util.Scanner;

public class P01Triangle {
   public class Triangle{
        private double side1;
        private double side2;
        private double side3;


        public Triangle(){};//Конструктор без параметър

       public Triangle(double number){ //конструктор с един параметър за създаване на равностранен тригълник
            this.side1=number;
            this.side2=number;
            this.side3=number;

       }
       public Triangle(double num1, double num2,double num3){//конструктор с 3 параметъра
           this.side1=num1;
           this.side2=num2;
           this.side3=num3;
       }
        public double getSide1(){
           return side1;
        }
        public double getSide2(){
           return side2;
        }
       public double getSide3(){
           return side3;
       }

       public void setSide1(double side1) {
           this.side1 = side1;
       }

       public void setSide2(double side2) {
           this.side2 = side2;
       }

       public void setSide3(double side3) {
           this.side3 = side3;
       }
       public boolean isTriangle(){ //Task1.4
            return (side1+side2>side3)&&
                    (side1+side3>side2)&&
                    (side2+side3>side1);
       }
       public void increaseSideLength(double number){
           if(number<0){
               System.out.println("Invalid");
           }else{
               this.side1+=number;
               this.side2+=number;
               this.side3+=number;
           }
       }
       public double perimeter(){
           return side1+side2+side3;
       }
       public double area(){
           return Math.sqrt(perimeter() / 2
                   * (perimeter() / 2 - side1)
                   * (perimeter() / 2 - side2)
                   * (perimeter() / 2 - side3));
       }
       boolean isEquilateral(){
           return side1==side2 && side1==side3;
       }
       public boolean isRectangular(){
               boolean isRectangular = (Math.pow(side1, 2) == Math.pow(side2, 2) + Math.pow(side3, 2))
                       || (Math.pow(side2, 2) == Math.pow(side1, 2) + Math.pow(side3, 2))
                       || (Math.pow(side3, 2) == Math.pow(side2, 1) + Math.pow(side2, 2));
               return isRectangular;
       }
       private static double hugeNumber=100;
       public boolean isTriangleHuge(){
           return this.perimeter()>=hugeNumber;
       }

       public static double getHugeNUmber(){
           return hugeNumber;
       }
       public static void setHugeNumber(double hugeNumber){
           Triangle.hugeNumber=hugeNumber;
       }
       @Override
       public String toString(){
           return "Triangle{" + "side1=" + side1 +
                   ", side2=" + side2 + ", side3=" + side3 + '}';
       }
   }

    static void main() {
        Scanner scanner=new Scanner(System.in);

        System.out.println("Enter huge number");
        Triangle.setHugeNumber(scanner.nextDouble());

        System.out.println("Enter three side of triangle");

    }


}
