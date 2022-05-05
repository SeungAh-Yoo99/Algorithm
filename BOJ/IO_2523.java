import java.util.*;

public class IO_2523 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		for (int i=0;i<n;i++) {
			for (int j=0;j<=i;j++)
				System.out.print("*");
			System.out.println();
		}
		
		for (int i=n-1;i>0;i--) {
			for (int j=0;j<i;j++)
				System.out.print("*");
			System.out.println();
		}
	}

}