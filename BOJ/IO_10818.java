import java.util.Scanner;

public class IO_10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();;
		int n[]=new int[num];
		for (int i=0;i<num;i++)
			n[i]=scan.nextInt();
		
		int min=n[0];
		int max=n[0];
		for (int i=0;i<num;i++) {
			if (min>=n[i])
				min=n[i];
			if (max<=n[i])
				max=n[i];
		}
		
		System.out.println(min+" "+max);
		
	}

}