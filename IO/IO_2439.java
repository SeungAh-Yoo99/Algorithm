import java.util.Scanner;

public class IO_2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int count=scan.nextInt();
		
		for (int i=count-1;i>=0;i--) {
			for (int j=1;j<=i;j++)
				System.out.print(" ");
			for (int j=1;j<=count-i;j++)
				System.out.print("*");
			System.out.println();
		}
	}

}