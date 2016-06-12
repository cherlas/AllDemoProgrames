package number_4;

public class Program4_1奥数等式 {
	private static int[] a=new int[10],book=new int[10];
	private static int total=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			book[i]=0; 
			a[i]=0;
		}
		dfs(1);
		System.out.println("total="+total/2);
	}
	private static void dfs(int step) {
		// TODO Auto-generated method stub
		if(step==10){
			if(((a[1]*100+a[2]*10+a[3])+(a[4]*100+a[5]*10+a[6]))==(a[7]*100+a[8]*10+a[9])){
				total++;
				System.out.println((a[1]*100+a[2]*10+a[3])+"+"+(a[4]*100+a[5]*10+a[6])+"="+(a[7]*100+a[8]*10+a[9]));
			}
			return;
		}
		for(int i=1;i<=9;i++){
			if(book[i]==0){
				a[step]=i;
				book[i]=1;
				dfs(step+1);
				book[i]=0;
			}
		}
		return;
	}

}
