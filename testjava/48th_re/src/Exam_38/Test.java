package Exam_38;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
     static    Point[] points = new Point[100];
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice =0;


        while (true){
            System.out.println("1.원 2.사각형 3.전체보기 4.종료");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1: circle(); break;
                case 2: rectangle(); break;
                case 3: allview(points[0]); break;
                case 4: return;
            }
        }
    }
    public static void circle(){
        int x, y, r;
        Scanner sc = new Scanner(System.in);

        System.out.print("x = ");
        x = sc.nextInt();
        System.out.print("y = ");
        y = sc.nextInt();
        System.out.print("r = ");
        r = sc.nextInt();
        Circle circle = new Circle(x,y,r);
        points[0] = circle;
    }
    public static void rectangle(){
        int x, y, w,h;
        Scanner sc = new Scanner(System.in);
        System.out.print("x = ");
        x = sc.nextInt();
        System.out.print("y = ");
        y = sc.nextInt();
        System.out.print("w = ");
        w = sc.nextInt();
        System.out.print("h = ");
        h = sc.nextInt();
        Rectangle rectangle1 = new Rectangle(x,y,w,h);
    }
    public static void allview(Point p){

        System.out.println(p.toString());
        }
    }

