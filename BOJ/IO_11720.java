import java.util.Scanner;

public class IO_11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		String nums=scan.next();
		char num;
		int sum=0;
		
		for (int i=0;i<N;i++) {
			num=nums.charAt(i);
			sum+=Character.getNumericValue(num);
		}
		System.out.println(sum);
	}

}