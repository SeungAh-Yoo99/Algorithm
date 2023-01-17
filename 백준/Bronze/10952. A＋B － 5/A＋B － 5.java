import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int num1;
		int num2;
		
		while(true) {
			num1=scan.nextInt();
			num2=scan.nextInt();
			
			if ((num1==0)&&(num2==0))
				break;
			else
				System.out.println(num1+num2);
		}
	}

}