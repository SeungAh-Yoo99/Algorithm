import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int room[] = new int[t];
		
		for (int i=0; i<t; i++) {
			int h = scan.nextInt();
			int w = scan.nextInt();
			int n = scan.nextInt();
			int height;
			int width;
			
			if (n%h == 0) {
				height = h;
				width = n/h;
			}
			else {
				height = n%h;
				width = n/h+1;
			}
			
			room[i]=height*100+width;
		}
		
		for (int i=0; i<t; i++)
			System.out.println(room[i]);
	}

}