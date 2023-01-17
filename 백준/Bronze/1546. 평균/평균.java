import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		double score[]=new double[n];
		double max=0;
		double avg=0;
		
		for (int i=0;i<n;i++) {
			score[i]=scan.nextDouble();
			max=Math.max(max,score[i]);
		}
		
		for (int i=0;i<n;i++) {
			score[i]=score[i]/max*100;
			avg+=score[i];
		}
		avg/=n;
		System.out.println(avg);
	}

}