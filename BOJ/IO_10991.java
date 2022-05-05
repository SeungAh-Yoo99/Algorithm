import java.util.Scanner;

public class IO_10991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		
		for (int i=1;i<=N;i++) {
			for (int j=N-i;j>0;j--)
				System.out.print(" ");
			System.out.print("*");
			for (int j=1;j<i;j++)
				System.out.print(" *");
			System.out.println();
		}
	}

}
