import java.util.*;

public class IO_10996 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		
		for (int i=0; i<n; i++) { // for문 안의 출력을 전체적으로 n번 반복
			if (n%2==0) { // n이 짝수면
				for (int j=0;j<n/2;j++) // n/2번 "* "를 출력하고
					System.out.print("* "); 
				System.out.println(); // 다음 줄에
				for (int j=0;j<n/2;j++) // n/2번 " *"를 출력
					System.out.print(" *");
				System.out.println();
			}
			else { // n이 홀수면
				for (int j=0;j<n/2+1;j++) // n/2+1번 "* "를 출력하고
					System.out.print("* ");
				System.out.println(); // 다음 줄에
				for (int j=0;j<n/2;j++) // n/2번 " *"를 출력
					System.out.print(" *");
				System.out.println();
			}
		}
	}

}