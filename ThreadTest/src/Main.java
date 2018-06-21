import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 解决方案 ：对三点A，B，C形成的三角形进行面积计算
 * 再对随机点D分别与AB,AC，BC形成的三角形进行计算
 * 1.如果上述三个三角形的面积与ABC的面积相等  则D在三角形内部
 * 2.如果三个三角形中有任意一个面积为0 则D在对应的边上
 * 3.否则D在三角形外部
 */

public class Main {

    private static boolean[] target = new boolean[1000];

    /**
     * 随机生成一千个点
     * @return  将放有一千个点的List返回
     */
    public static List generateRandomNumber(){
        Random random = new Random();
        double x = 0;
        double y = 0;

        List list = new ArrayList();


        for(int i=0; i<1000; i++) {
            x = random.nextInt(10)+1;
            y = random.nextInt(10)+1;
            Point point = new Point(x,y);
            list.add(point);
            target[i] = true;
//            System.out.printf("x : %f%n  y : %f%n ",point.getX(),point.getY());
        }
        System.out.println(list);
        return list;
    }

    /**
     * 利用叉乘计算三角形面积
     * @param pt0
     * @param pt1
     * @param pt2
     * @return
     */
    public static double caculateArea(Point pt0, Point pt1, Point pt2){
        Point AB = new Point();
        Point BC = new Point();
        AB.setX(pt1.getX() - pt0.getX());
        AB.setY(pt1.getY() - pt0.getY());
        BC.setX(pt2.getX() - pt1.getX());
        BC.setY(pt2.getY() - pt1.getY());

        return Math.abs(AB.getX()*BC.getY()-AB.getY()*BC.getX())/2;

    }


    /**
     * 判断点d是否在三角形内部
     * @param a
     * @param b
     * @param c
     * @param d
     * @return
     */
    public static boolean isInTriangle(Point a, Point b, Point c, Point d){
        double abcS,adbS,bdcS,adcS;
        abcS = caculateArea(a,b,c);
        adbS = caculateArea(a,d,b);
        bdcS = caculateArea(b,d,c);
        adcS = caculateArea(a,d,c);

        System.out.printf("abcS : %f%n  adbS : %f%n  bdcS : %f%n  adcS : %f%n",abcS,adbS,bdcS,adcS);

        double sumArea = adbS + bdcS + adcS;

        if(sumArea == abcS){
            if(adbS>1e-4 && bdcS>1e-4 && adcS>1e-4){
                System.out.println("该点位于三角形内部");
                return true;
            }else if(Math.abs(adbS) <= 1e-4){
                System.out.println("该点位于三角形AB边上");
                return true;
            }else if(Math.abs(bdcS) <= 1e-4){
                System.out.println("该点位于三角形BC边上");
                return true;
            }else if(Math.abs(adcS) <= 1e-4){
                System.out.println("该点位于三角形AC边上");
                return true;
            }else {
                return true;
            }
        }else{
            System.out.println("该点位于三角形外部");
            return false;
        }
    }

    public static void main(String[] args) {
        List<Point> point = Main.generateRandomNumber();
        Random random = new Random();
        int[] range = new int[3];

        //随机获取三个点
        for(int i=0; i<3; i++){
            range[i] = random.nextInt(1000)+1;
            target[range[i]] = false;
        }

        for(int i=0; i<1000; i++){
            if(target[i] == true){
                Main.isInTriangle(point.get(range[0]),point.get(range[1]),point.get(range[2]),point.get(i));
            }else{
                System.out.println("选取点重合");
            }
        }
    }
}
class Point {
    private double x;
    private double y;

    public Point(){}

    public Point(double x,double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}

