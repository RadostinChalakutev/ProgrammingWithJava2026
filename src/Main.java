/* Да се напише програма, която проверява дали една година е високосна.
На променливата leapYear да се присвои стойността на годината, ако тя е
 високосна, в противен случай на променливата leapYear да се присвои стойност
-1. Използвайте тернарен оператор. Покажете стойността на променливата leapYear.*/

void main() {
    Scanner scanner=new Scanner(System.in);
    int year=Integer.parseInt(scanner.nextLine());

    if(year%4!=0){
        year=-1;
        System.out.println(year);

    }else{
        System.out.print("Year "+year+" is leaf.");
    }


}