import java.util.*;

public class IO_1330 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		
		if (a>b)
			System.out.println(">");
		else if (a<b)
			System.out.println("<");
		else
			System.out.println("==");
	}

}