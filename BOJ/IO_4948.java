import java.util.*;

public class IO_4948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		
		while (true) {
			int n = scan.nextInt();
			if (n == 0)
				break;
			
			int count = 0;
			for (int i=n+1; i<=2*n; i++) {
				int j;
				for (j=2; j*j<=i; j++)
					if (i%j == 0)
						break;
				if ((j*j > i)==(i != 1))
					count++;
			}
			System.out.println(count);
		}
	}

}