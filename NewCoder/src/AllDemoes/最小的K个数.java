package AllDemoes;

/**
 * Created by Yogurt on 6/20/16.
 */
public class 最小的K个数 {
    public static void main(String[] args){
        int[] ints=new int[]{4,5,1,6,2,7,3,8};
        quickSort(ints,0,ints.length-1);
        for(int i=0;i<ints.length;i++)
            System.out.print(ints[i]+" ");
    }
    public static void quickSort(int[] input,int s,int e){
        int low=s,high=e;
        int pro=input[s];
        if(low>=high) return;
        while(low<high){
            while(low<high&&input[high]>pro) high--;
            if (low>=high) break;
            while(low<high&&input[low]<=pro) low++;
            if (low>=high) break;
            int t=input[low];
            input[low]=input[high];
            input[high]=t;
            System.out.println("low="+low+"  high="+high);
            for(int i=0;i<input.length;i++)
                System.out.print(input[i]+" ");
            System.out.println();
        }
        int t=input[low];
        input[low]=pro;
        input[s]=t;
        quickSort(input,s,low-1);
        quickSort(input,low+1,e);
    }
}
