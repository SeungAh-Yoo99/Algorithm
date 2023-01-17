import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		int i = 2;
		
		while(i <= n) {
			if (n%i == 0) {
				System.out.println(i);
				n = n/i;
			}
			else
				i++;
		}
	}

}