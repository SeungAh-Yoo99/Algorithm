import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt();
		int count = 0;
		
		for (int i=0; i<n; i++) {
			int num = scan.nextInt();
			int j;
			for (j=2; j*j<=num; j++)
				if (num % j == 0)
					break;
			if ((j*j>num)&&(num != 1))
				count++;
		}
		
		System.out.println(count);
	}

}