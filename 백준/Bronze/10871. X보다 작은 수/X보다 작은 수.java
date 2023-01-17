import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int x=scan.nextInt();
		int a[]=new int[n];
		
		for (int i=0;i<n;i++)
			a[i]=scan.nextInt();
		
		for (int i=0;i<n;i++) {
			if (a[i]<x)
				System.out.print(a[i]+" ");
		}
		System.out.println();
	}

}