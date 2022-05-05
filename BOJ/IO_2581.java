import java.util.*;

public class IO_2581 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		int count = 0;
		int sum = 0;
		int min = 0;
		
		for (int i=m; i<=n; i++) {
			int j;
			for (j=2; j*j<=i; j++)
				if (i % j == 0)
					break;
			if ((j*j > i)&&(i != 1)) {
				sum += i;
				if (count == 0)
					min = i;
				count++;
			}
		}
		
		if (count == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
			
	}

}