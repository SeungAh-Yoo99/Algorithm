import java.util.Scanner;

public class IO_2446 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();

		for (int i=1;i<=N;i++) {
			for (int j=1;j<=i-1;j++)
				System.out.print(" ");
			for (int j=1;j<=2*(N-i+1)-1;j++)
				System.out.print("*");
			System.out.println();
		}
		
		for (int i=1;i<N;i++) {
			for (int j=N-i-1;j>=1;j--)
				System.out.print(" ");
			for (int j=1;j<=2*i+1;j++)
				System.out.print("*");
			System.out.println();
		}
	}
}