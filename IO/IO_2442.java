import java.util.Scanner;

public class IO_2442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		
		for (int i=1;i<=num;i++) {
			for (int j=1;j<=num-i;j++) //왼쪽 공백 다음 줄로 가면 한 칸씩 줄어든다.
				System.out.print(" ");
			for (int j=1;j<=(i*2-1);j++) //2i-1만큼 * 출력
				System.out.print("*");
			System.out.println();
		}
	}

}