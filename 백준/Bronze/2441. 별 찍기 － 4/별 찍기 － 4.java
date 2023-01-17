import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int count=scan.nextInt();
		
		for (int i=count;i>=1;i--) {
			for (int j=1;j<=count-i;j++)
				System.out.print(" ");
			for (int j=1;j<=i;j++)
				System.out.print("*");
			System.out.println();
		}
	}

}