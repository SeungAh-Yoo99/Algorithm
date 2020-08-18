import java.util.Scanner;

public class IO_10951 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int num1;
		int num2;
		
		while (scan.hasNextInt()) {
			num1=scan.nextInt();
			num2=scan.nextInt();
			
			System.out.println(num1+num2);
		}
	}
