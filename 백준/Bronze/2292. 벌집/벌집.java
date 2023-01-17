import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int layer=1;
		int num=0; // 현재 층의 육각형의 개수
		int totalNum=1; // 전체 층의 육각형의 개수
		
		while (true) {
			if (n<=totalNum)
				break;
			else {
				num+=6;
				totalNum+=num;
				layer++;
			}
		}
		System.out.println(layer);
	}

}