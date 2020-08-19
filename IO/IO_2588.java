import java.util.*;

public class IO_2588 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num1=scan.nextInt();
		int num2=scan.nextInt();
		int num3=num1*(num2%10);
		int num4=num1*(num2%100/10);
		int num5=num1*(num2/100);
		
		System.out.println(num3);
		System.out.println(num4);
		System.out.println(num5);
		System.out.println(num1*num2);
	}

}