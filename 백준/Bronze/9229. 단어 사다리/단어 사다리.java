import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 단어 사다리 가능 조건
		// 1. 먼저 입력 받은 단어와 다음 입력 받은 단어, 두 단어의 길이가 같아야 함
		// 2. 두 단어가 한글자만 달라야 함
		
		boolean correct = true;
		char[] c2 = br.readLine().toCharArray();
		while(true) {
			char[] c1 = c2;
			c2 = br.readLine().toCharArray(); // 다음 문자 입력
			
			if(c2[0] == '#') { // 입력 받은 단어가 '#'일때
				if(c1[0] == '#') { // '#'이 연속으로 두 번 나왔다면 반복문 탈출
					break;
				}
				else { // 하나의 단어 사다리가 끝난 경우
					if(correct) {
						sb.append("Correct\n"); // 끝난 단어 사다리의 결과 저장
					}
					else {
						sb.append("Incorrect\n");
					}
					correct = true;
					continue; // 새로운 단어 하나를 더 입력 받으러 감.
				}
			}
			if(c1[0] == '#') { // 단어 하나 더 입력 받으러 감
				continue;
			}
			
			// 이미 단어 사다리가 불가능하면 조건을 확인하지 않음
			if(correct) {
				// 조건1. 단어의 길이가 같은지 확인
				if(c1.length != c2.length) { // 같지 않다면
					correct = false;
					continue;
				}
				// 조건2. 단어가 하나만 다름
				int count = 0;
				for (int i = 0; i < c1.length; i++) {
					if(c1[i] != c2[i]) count++; // 같지 않은 단어가 나오면 카운트해줌
				}
				if(count != 1) { // 다른 단어가 딱 1개가 아니면
					correct = false;
				}
			}
		}
		
		// 답 출력
		System.out.println(sb);
	}

}