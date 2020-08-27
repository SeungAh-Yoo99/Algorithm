import java.util.*;

public class IO_2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int t=scan.nextInt();
		int r[]=new int[t];
		String s[]=new String[t];
		
		for (int i=0;i<t;i++) {
			r[i]=scan.nextInt();
			s[i]=scan.next();
		}
		
		for (int i=0;i<t;i++) {
			for (int j=0;j<s[i].length();j++) {
				char c=s[i].charAt(j);
				for (int k=0;k<r[i];k++)
					System.out.print(c);
			}
			System.out.println();
		}
	}

}