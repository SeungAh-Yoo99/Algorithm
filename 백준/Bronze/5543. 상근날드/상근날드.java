import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int hbg[]=new int[3];
		int drk[]=new int[2];
		int min;
		
		for (int i=0;i<3;i++)
			hbg[i]=scan.nextInt();
		
		min=hbg[0];
		for (int i=1;i<3;i++)
			min=Math.min(min,hbg[i]);
		
		for (int i=0;i<2;i++)
			drk[i]=scan.nextInt();
		min+=Math.min(drk[0], drk[1]);
		
		min-=50;
		System.out.println(min);
	}

}