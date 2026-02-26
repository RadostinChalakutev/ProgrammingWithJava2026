package P01;
/*Да се намерят корените на квадратно уравнение
ax2 + bx + c = 0; Необходимо е да се разграничат
3 случая: дискриминанта == 0, дискриминанта > 0 и дискриминанта < 0*/

import java.util.Scanner;

public class quadraticЕquation {

    static void main() {
        Scanner scanner=new Scanner(System.in);

       double a=Double.parseDouble(scanner.nextLine());
       double b=Double.parseDouble(scanner.nextLine());
       double c=Double.parseDouble(scanner.nextLine());

        double d=b*b-(4*a*c);

        if(d<0){
            System.out.println("No real roots");
        }else if(a!=0){
            if(d==0){
                double root=-b/(2*a);
                System.out.println("The root is "+root);
            }else {
                double root1=-b+(Math.sqrt(d))/(2*a);
                double root2=-b-(Math.sqrt(d))/(2*a);
                System.out.println("The roots are  "+root1+" and "+root2);
            }
        }else{
            System.out.println("Cannot divide by 0");
        }

    }
}
