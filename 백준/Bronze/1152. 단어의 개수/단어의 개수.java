import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String s=scan.nextLine();
		s=s.trim(); // 문자열의 앞 뒤 공백을 없애준다.
		if (s.isEmpty()) // 문자열에 아무것도 입력되지 않았으면 단어의 수는 0이므로 0 출력
			System.out.println(0);
		else {
			String str[]=s.split(" ");// 공백을 기준으로 문자열을 나눠 배열에 넣는다.
			System.out.println(str.length); // 배열의 크기가 단어의 개수가 된다.
		}
	}

}
