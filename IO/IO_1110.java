import java.util.*;

public class IO_1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int num=n;
		int count=0;
		int num1;
		int num2;
		
		do {
			if (num<10) num1=0;
			else num1=num/10;
			num2=num%10;
			num=num2*10+(num1+num2)%10;
			count++;
		} while (n!=num);
		
		System.out.println(count);
	}

}