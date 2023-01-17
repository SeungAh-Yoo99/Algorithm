import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int count=0;
		
		while (n%5!=0) {
			n-=3;
			if (n<0) {
				count=-1;
				break;
			}
			else
				count++;
		}
		
		if (n>0)
			count+=n/5;
		
		System.out.println(count);
	}

}