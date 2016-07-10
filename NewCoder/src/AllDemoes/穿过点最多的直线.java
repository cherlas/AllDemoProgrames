package AllDemoes;

import java.util.*;

/**
 * Created by Yogurt on 16/7/10.
 */
public class 穿过点最多的直线 {
    private static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Point() {
            this.x = 0;
            this.y = 0;
        }
    }
    private static class Line{
        double k;
        double b;
        public Line(double k,double b){
            this.k=k;
            this.b=b;
        }
        @Override
        public boolean equals(Object obj){
            if (obj instanceof Line)
            if (isEqualValue(k,((Line)obj).k)&&isEqualValue(b,((Line)obj).b))
                return true;
            return false;
        }

        private boolean isEqualValue(double k, double k1) {
            return Math.abs(k-k1)<0.0001;
        }

        public int hashCode(){
            String str= String.valueOf(k)+String.valueOf(b);
            return str.hashCode();
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextInt()){
            int n=sc.nextInt();
            Point[] p=new Point[n];
            for (int i=0;i<n;i++)
                p[i]=new Point(sc.nextInt(),sc.nextInt());
            Map<Line,Integer> line=new HashMap<>();
            double maxK=0,maxB=0;
            int maxLine=0;
            for (int i=0;i<n;i++){
                for (int j=i+1;j<n;j++){
                    double k=(p[j].y-p[i].y)/(p[j].x-p[i].x);
                    double b=p[j].y-p[j].x*k;
                    Line l=new Line(k,b);
                    if (line.containsKey(l)){
                        int num=line.get(l)+1;
                        line.put(l,num);
                        if (num>maxLine){
                            maxLine=num;
                            maxK=k;
                            maxB=b;
                        }
                    }else {
                        line.put(l,1);
                    }
                }
            }
            System.out.println(maxK+" "+maxB);
        }
    }
}
