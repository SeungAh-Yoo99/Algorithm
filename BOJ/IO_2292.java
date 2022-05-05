/*
[그림 1]
위의 그림에서 각각 다른 색으로 층을 나눠 보았다.
다음 그림을 표로 정리하면 아래와 같다.
[표 1]
위의 표에서 알 수 있는 사실은 각 층은 전의 층보다 6개 만큼의 육각형이 더 있다.
각 면에서 하나씩 육각형이 더 생기는 구조이다.
6개의 면에서 하나씩 더 생기므로 층이 증가할 때마다 6개 만큼의 육각형이 더 생기는 것이다.

n층에서 중앙인 1 즉, 1층으로 가기 위해서는 n개의 방을 지나가야 한다.
따라서 전달 받은 숫자가 몇 층에 존재하는지만 알면 최소 몇 개의 방을 지나가야 하는지 알 수 있다.
 */
import java.util.*;

public class IO_2292 {

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