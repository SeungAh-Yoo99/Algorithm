/*
우선 처음에는 n을 구할 때
while (a+b*n>=c*n)
	n++;
를 사용해서 n을 구했었다.
이 경우에는 시간 초과가 떴다.
따라서 반복문을 쓰지 않고 n=a/(c-b)+1을 이용해 n을 구했다.

그런데 문제 조건 중에 손익분기점이 존재하지 않으면 -1을 출력한다는 조건을 보지 못했다.
손익분기점이 존재하지 않는 경우는 b가 c보다 같거나 크다면 절대로 손익분기점이 생길 수 없다.
따라서 손익분기점이 존재하지 않는 경우를 추가해줬다.
 */
import java.util.*;

public class IO_1712 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int c=scan.nextInt();
		int n;
		
		if (b>=c)
			n=-1;
		else
			n=a/(c-b)+1;
		
		System.out.println(n);
	}

}