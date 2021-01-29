package CLB;

import java.util.Scanner;

public class bai1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        double x1,y1,x2,y2;
        double r;
        System.out.printf("Mời bạn nhập vào tọa độ điểm A:");
        x1= s.nextInt();
        y1= s.nextInt();
        System.out.printf("Mời bạn nhập vào tọa độ tâm O:");
        x2= s.nextInt();
        y2= s.nextInt();
        System.out.println("Mời bạn nhập vào bán kính R");
        r = s.nextInt();
        double d= Math.sqrt(Math.abs(x2-x1) + Math.abs(y2-y1));
        if (d==r)
        {
            System.out.println("Điểm A nằm trên đường tròn");
        }
        else if (d<r)
        {
            System.out.println("Điểm A nằm trong đường tròn");
        }
        else if (d>r)
        {
            System.out.println("Điểm A nằm ngoài đường tròn");
        }
    }
}
