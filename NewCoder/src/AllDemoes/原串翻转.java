package AllDemoes;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 原串翻转 {
    public static void main(String[] args){
        String str="This is nowcoder";
        char[] result=new char[str.length()];
        for(int i=0;i<str.length()/2+1;i++){
            result[i]=str.charAt(str.length()-i-1);
            result[str.length()-i-1]=str.charAt(i);
        }
        System.out.println(result);
    }
}
