/*
처음에 반복문으로 day를 구하기로 했다.
하지만 이 방법을 사용하면 시간 초과가 나온다.
따라서 반복문 말고 식을 이용해 day를 한 번에 구해야 한다.

day를 n이라고 할 때, n의 최소값을 구하는 식은 다음과 같다.
an-b(n-1) >= v
an-bn+b >= v
(a-b)n >= v-b
n >= (v-b)/(a-b)
 */
import java.util.*;

public class IO_2869 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int v = scan.nextInt();
		int day = 0;
		
		if ((v-b)%(a-b) == 0)
			day = (v-b)/(a-b);
		else
			day = (v-b)/(a-b)+1;
		
		System.out.println(day);
	}

}