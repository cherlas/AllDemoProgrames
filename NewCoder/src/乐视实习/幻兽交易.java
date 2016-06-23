package 乐视实习;

import java.util.Scanner;

public class 幻兽交易 {
    private static Scanner  sc;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        sc=new Scanner(System.in);
        while(sc.hasNext()) {
            double A=sc.nextDouble();
            double B=sc.nextDouble();
            if(A>=B) System.out.println(0);
            else {
                int count=0;
                for(int i=(int) Math.ceil(A/19);i<=Math.floor(A/9);i++) 
                    if(A+i<=B&&(A+i)%5==0)
                        count++;
                System.out.println(count);
            }
            
        }
    }

}


//import java.util.Scanner;
//
//
//
//public class Main {
// 
//  
// 
//    public static void main(String[] args) {
// 
//        Scanner scanner = new Scanner(System.in);
// 
//        while(scanner.hasNext())
// 
//        {
// 
//            double A = scanner.nextDouble();//本该支付的费用
// 
//            double B = scanner.nextDouble();//总金额
// 
//              
// 
//            int start = (int)Math.ceil(A/0.95);
// 
//            int end = (int)Math.floor(A/0.9);
// 
//              
// 
//            int k = 0;
// 
//            while(start%5!=0&& start <=end)
// 
//            {
// 
//                start++;
// 
//            }
// 
//            for(int i=start;i<=end && i<=B;i+=5)
// 
//            {
// 
//                if(i%5==0)
// 
//                {
// 
//                    k++;
// 
//                }
// 
//            }
// 
//            System.out.println(k);
// 
//        }
// 
//    }
// 
//  
// 
//}