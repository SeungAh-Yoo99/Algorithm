import java.util.Scanner;

public class IO_11721 {

	public static void main(String args[]) {
		
		Scanner scan=new Scanner(System.in);
		String str=scan.next();
		int count=1;
		char c;
		
		for (int i=0;i<str.length();i++) {
			c=str.charAt(i);
			System.out.print(c);
			if ((count%10)==0)
				System.out.println();
			count++;
		}
	}
}