/*
div에 저장할 때 (double)로 변수형변환을 해주지 않으면 div에 a/b의 몫이 저장된다.
 */
import java.util.Scanner;

public class IO_1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		double div=(double)a/b;
		System.out.println(div);
	}

}