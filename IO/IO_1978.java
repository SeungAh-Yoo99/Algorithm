/*
소수를 구하는 방법은 여러 가지가 있다.
1. 1부터 n-1까지의 수로 n을 나눠 보았을 때 나머지가 0인 수가 있다면 n은 소수가 아니다.
이 경우에는 O(n)의 시간이 걸린다.
2. 1부터 n/2까지의 수로 n을 나눠 보았을 때 나머지가 0인 수가 있다면 n은 소수가 아니다.
1부터 n/2까지의 수에서 나눴을 때 나머지가 0인 수가 나오지 않았다면 n/2 이상의 수로 나눴을 때도 나머지가 0인 수는 있을 수 없다.
이 경우에는 O(n/2)의 시간이 걸린다.
3. 1부터 루트 n까지의 수로 n을 나눠 보았을 때 나머지가 0인 수가 있다면 n은 소수가 아니다.
1부터 루트 n까지의 수에서 나눴을 때 나머지가 0인 수가 나오지 않았다면 루트 n 이상의 수로 나눴을 때도 나머지가 0인 수는 있을 수 없다.
이 경우에는 O(루트 n)의 시간이 걸린다.

이 방법들을 볼 때 3번의 방법을 쓰는 것이 시간이 가장 적게 걸린다.
따라서 이 문제를 3번의 방법으로 풀었다.
루트 n을 따로 구해주진 않고 i*i<n 을 반복문 조건으로 하여 문제를 풀었다.
 */
import java.util.*;

public class IO_1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner (System.in);
		int n = scan.nextInt();
		int count = 0;
		
		for (int i=0; i<n; i++) {
			int num = scan.nextInt();
			int j;
			for (j=2; j*j<=num; j++)
				if (num % j == 0)
					break;
			if ((j*j>num)&&(num != 1))
				count++;
		}
		
		System.out.println(count);
	}

}