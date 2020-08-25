import java.util.Scanner;

public class IO_10992 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		
		for (int i=1;i<N;i++) //첫줄
			System.out.print(" ");
		System.out.println("*");
		
		for (int i=2;i<N;i++) { //중간줄
			for (int j=N-i;j>0;j--) //앞 공백
				System.out.print(" ");
			System.out.print("*");
			for (int j=1;j<=2*(i-1)-1;j++) //가운데 공백
				System.out.print(" ");
			System.out.println("*");
		}
		
		if (N!=1) {//막줄 (N이 1일 시에는 출력하지 않는다.
			for (int i=1;i<=2*N-1;i++)
				System.out.print("*");
			System.out.println();
		}
	}

}