import java.util.*;

public class IO_10953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		int ans[]=new int[t];
		
		for (int i=0;i<t;i++) {
			String s=scan.next();
			String arr[]=s.split(",");
			int num1=Integer.parseInt(arr[0]);
			int num2=Integer.parseInt(arr[1]);
			ans[i]=num1+num2;
		}
		
		for (int i=0;i<t;i++)
			System.out.println(ans[i]);
	}

}