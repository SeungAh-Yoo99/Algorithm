import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		int arr[]=new int[10];
		int mul=a*b*c;
		int num;
		
		for (int i=1;i<=mul;i*=10) {
			num=((mul%(i*10))/i);
			arr[num]++;
		}
		
		for (int i=0;i<10;i++)
			System.out.println(arr[i]);
	}

}