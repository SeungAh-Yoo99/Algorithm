/*
처음에 문제를 이해하지 못했었다.
그래서 다른 분들의 문제 해석을 참고하여 문제를 이해했다.
한 단어 aaccbbc가 있을 때, c가 맨 처음 나온 c와 연속해서 오지 않고 다른 문자가 나온 다음에 다시 나온다.
이럴 경우 그룹 단어가 아니다.
aacccbb 같은 경우에, 모든 문자들이 자신과 같은 문자와는 연속해서 나오고 있다.
이럴 경우에는 그룹 단어라고 한다.
 */
import java.util.*;
public class IO_1316 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int count=0; // 그룹 단어 개수
		
		for (int i=0;i<n;i++) {
			String s=scan.next();
			Vector<Character> v=new Vector<Character>(); // 단어에 존재하는 문자들 저장
			Iterator<Character> it;
			int notNew=0; // notNew가 1이면 새로운 문자가 아니다.
			
			for (int j=0;j<s.length();j++) {
				notNew=0;
				it=v.iterator();
				while (it.hasNext()) { // 해당 문자가 앞에 나왔었는지 확인
					char c=it.next();
					if (c==s.charAt(j)) // 앞에서 나온 적 있는 문자일 경우
						notNew=1;
				}
				if (notNew==0) { // 처음 나온 문자일 경우
					v.add(s.charAt(j)); // Vector v에 해당 문자를 추가해주고
					while (true) {// 다른 문자가 나올 때까지 j에 1 더해준다.
						if (j<s.length()-1) {
							if (s.charAt(j)==s.charAt(j+1))
								j++;
							else
								break;
						}
						else
							break;
					}
				}
				else // notNew가 1이라면 이 단어는 그룹 단어가 아니다.
					break;
			}
			if (notNew==0)
				count++;
		}
		System.out.println(count);
	}

}