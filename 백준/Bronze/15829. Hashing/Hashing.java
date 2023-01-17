import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		
		int l = scan.nextInt();
		char[] c = scan.next().toCharArray();
		int h = 0;
		
		for(int i = 0; i < l; i++) {
			h += ((char)c[i] - 96) * Math.pow(31, i);
		}
		
		int ans = h % 1234567891;
		System.out.println(ans);
	}

}