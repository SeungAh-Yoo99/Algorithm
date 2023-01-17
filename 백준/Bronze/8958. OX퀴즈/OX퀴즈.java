import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int score[]=new int[n];
		
		for (int i=0;i<n;i++) {
			int s=0;
			String rst=scan.next();
			int count=0; // 'O'가 연속으로 나온 개수
			for (int j=0;j<rst.length();j++) {
				char c=rst.charAt(j);
				if (c=='O') {
					count++;
					s+=count;
				}
				else
					count=0;
			}
			score[i]=s;
		}
		
		for (int i=0;i<n;i++)
			System.out.println(score[i]);
	}

}