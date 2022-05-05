import java.util.*;

public class IO_2753 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int year=scan.nextInt();
		
		if ((year%400)==0)
			System.out.println("1");
		else if (((year%4)==0)&&((year%100)!=0))
			System.out.println("1");
		else
			System.out.println("0");
	}

}