package Basic_Graph_Maker;

import java.util.Scanner;

public class MainGraph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        displayPro();
        System.out.print("Choose : ");
        option=sc.nextInt();
        switch(option){
            case 1:
                linearVal();
                break;
            case 2:
                quadraticVal();
                break;
            case 3:
                powerVal();
                break;
            default:
                System.out.println("Invalid option");
                break;
        }
    }
    
    public static void displayPro(){
        System.out.println("1.Linear");
        System.out.println("2.Quadratic");
        System.out.println("3.Power");
    }
    
    public static void linearVal(){
        Scanner sc = new Scanner(System.in);
        double a,c;
        System.out.println("y=ax+c");
        System.out.print("a = ");
        a=sc.nextDouble();
        System.out.print("c = ");
        c=sc.nextDouble();
        Linear x = new Linear(a,c);
        x.storeY();
        x.draw();
        
    }
    
    public static void quadraticVal(){
        Scanner sc = new Scanner(System.in);
        double a,b,c;
        System.out.println("y=ax^2+bx+c");
        System.out.print("a = ");
        a=sc.nextDouble();
        System.out.print("b = ");
        b=sc.nextDouble();
        System.out.print("c = ");
        c=sc.nextDouble();
        Quadratic x = new Quadratic(a,b,c);
        x.storeY();
        x.draw();
    }
    
    public static void powerVal(){
        Scanner sc = new Scanner(System.in);
        double a,b,c,d;
        System.out.println("y=ax^3+bx^2+cx+d");
        System.out.print("a = ");
        a=sc.nextDouble();
        System.out.print("b = ");
        b=sc.nextDouble();
        System.out.print("c = ");
        c=sc.nextDouble();
        System.out.print("d = ");
        d=sc.nextDouble();
        Power x = new Power(a,b,c,d);
        x.storeY();
        x.draw();
    }
    
}
