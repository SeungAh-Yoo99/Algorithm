import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		int n;
		
		if (b>=c)
			n=-1;
		else
			n=a/(c-b)+1;
		
		System.out.println(n);
	}

}