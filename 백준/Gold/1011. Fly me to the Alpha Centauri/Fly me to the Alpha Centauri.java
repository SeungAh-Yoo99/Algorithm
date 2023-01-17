import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int ans[] = new int[t];
		
		for (int i=0; i<t; i++) {
			int x = scan.nextInt();
			int y = scan.nextInt();
			int movingDis = 1;
			int xCount = 0;
			int yCount = 0;
			
			while (x < y) {
				x += movingDis;
				xCount++;
				
				if (x >= y)
					break;
				
				y -= movingDis;
				yCount++;
				movingDis++;
			}
			ans[i] = xCount+yCount;
		}
		
		for (int i=0; i<t; i++)
			System.out.println(ans[i]);
	}

}