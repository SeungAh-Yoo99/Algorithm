import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		int med=0;
		
		if (((a>=b)&&(a<=c))||((a<=b)&&(a>=c)))
				med=a;
		else if (((b>=a)&&(b<=c))||((b<=a)&&(b>=c)))
				med=b;
		else
			med=c;
		
		System.out.println(med);
	}

}