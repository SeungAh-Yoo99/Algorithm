import java.util.*;

public class IO_4344 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int c=scan.nextInt();
		double ratio[]=new double[c];
		for (int i=0;i<c;i++) {
			int n=scan.nextInt();
			int score[]=new int[n];
			double avg=0;
			for (int j=0;j<n;j++) {
				score[j]=scan.nextInt();
				avg+=score[j];
			}
			avg/=n;
			
			int count=0; // 평균을 넘는 학생 수 저장
			for (int j=0;j<n;j++)
				if (score[j]>avg)
					count++;
			ratio[i]=(double)count/n*100;
		}
		
		for(int i=0;i<c;i++) {
			System.out.printf("%.3f",ratio[i]);
			System.out.println("%");
		}
	}

}