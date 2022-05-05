import java.util.*;

public class IO_1929 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		for (int i=m; i<=n; i++) {
			int j;
			for (j=2; j*j<=i; j++)
				if (i%j == 0)
					break;
			if ((j*j > i)==(i != 1))
				System.out.println(i);
		}
	}

}