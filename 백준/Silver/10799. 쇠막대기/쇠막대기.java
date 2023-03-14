import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] bracket = br.readLine().toCharArray();
		
		int rodCount = 0; // 현재 위치에서 쌓인 쇠막대기 개수
		int result = 0; // 잘려진 쇠막대기 조각의 총 개수
		
		for (int i = 0; i < bracket.length; i++) {
			if(bracket[i] == '(') { // 여는 괄호가 나왔을 때, 쇠막대기의 왼쪽 끝인지, 레이저인지 확인
				if(bracket[i + 1] == ')') { // 바로 닫는 괄호가 나왔다면 레이저
					result += rodCount; // 현재 위치에서 쌓인 쇠막대기 개수만큼 잘려진 쇠막대기 조각이 나온다
					i++;
				}
				else rodCount++;
			}
			else { // 닫는 괄호가 나왔다면 쇠막대기의 오른쪽 끝이므로 쇠막대기 조각 수를 하나 더해준다
				result++;
				rodCount--;
			}
		}
		
		// 출력
		System.out.println(result);
	}

}