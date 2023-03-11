import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] calculation = br.readLine().toCharArray();
		
		ArrayList<Integer> num = new ArrayList<>();
		ArrayList<Character> operator = new ArrayList<>();
		
		// 숫자는 num에 연산자는 operator에 추가
		int nIdx = 0;
		for (int i = 0; i < calculation.length; i++) {
			if(calculation[i] == '+' || calculation[i] == '-') {
				int tmp = 0;
				for (int j = nIdx; j < i; j++) {
					tmp = tmp * 10 + (calculation[j] - '0');
				}
				num.add(tmp);
				operator.add(calculation[i]);
				nIdx = i + 1;
			}
		}
		// 마지막 숫자 추가
		int tmp = 0;
		for (int i = nIdx; i < calculation.length; i++) {
			tmp = tmp * 10 + (calculation[i] - '0');
		}
		num.add(tmp);
		
		// - 연산이 나오면 다음 - 연산이 나올 때까지 사이에 있는 + 연산을 모두 먼저 계산
		for (int i = 0; i < operator.size();) {
			if(operator.get(i) == '-') {
				i++;
				while(i < operator.size() && operator.get(i) == '+') {
					num.set(i, num.get(i) + num.get(i + 1));
					num.remove(i + 1);
					operator.remove(i);
				}
			}
			else i++;
		}
		
		// 남은 연산 마저 계산
		int result = num.get(0);
		for (int i = 0; i < operator.size(); i++) {
			if(operator.get(i) == '+') result += num.get(i + 1);
			else result -= num.get(i + 1);
		}
		
		// 출력
		System.out.println(result);
	}

}