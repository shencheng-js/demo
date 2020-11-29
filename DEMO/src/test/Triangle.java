package test;

import java.util.Scanner;

/**
 * @auther {shen}
 * @DATE 2020-11-3
 */
public class Triangle {
    private double a,b,c;
    public Triangle(double a,double b,double c){
        if(a+b>c&&a+c>b&&b+c>a) {
            a = this.a;
            b = this.b;
            c = this.c;
        }
        else{
            a=0;
            b=0;
            c=0;
        }
    }


    public double getPerimeter(){
        double P=a+b+c;
        return c;
    }
    public double getArea() {
        double area;
        double m = (a + b + c) / 2;
        area = Math.sqrt(m * (m - a) * (m - b) * (m - c));
        return area;
    }
    public static void main(String []args){
        double d,e,f;
        Scanner scanner = new Scanner(System.in);
        d=scanner.nextDouble();
        e=scanner.nextDouble();
        f=scanner.nextDouble();
        Triangle triangle= new Triangle(d,e,f);
        System.out.println("perimeter="+triangle.getPerimeter());
        System.out.println("area="+triangle.getArea());
        System.out.println("a="+triangle.a+",b="+triangle.b+",c="+triangle.c);
    }
}
