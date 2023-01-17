import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int max;
		
		if ((a%10)>(b%10)) // 우선 a, b의 일의 자리수부터 비교
			max=a;
		else if ((a%10)<(b%10))
			max=b;
		else { // 일의 자리수가 같다면
			if ((a%100/10)>(b%100/10)) // 다음으로 십의 자리수 비교
				max=a;
			else if ((a%100/10)<(b%100/10))
				max=b;
			else {// 십의 자리수도 같다면
				if ((a/100)>(b/100)) // 백의 자리수 비교
					max=a;
				else
					max=b;
			}	
		}
		max=(max%10)*100+(max%100/10)*10+(max/100); // max를 거꾸로 바꿔준다.
		System.out.println(max);
	}

}