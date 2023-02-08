import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 문자열 s 입력
		char[] s = br.readLine().toCharArray();
		
		// 답을 담을 StringBuilder
		StringBuilder sb = new StringBuilder();
		// 임시 StringBuilder
		StringBuilder tmp = new StringBuilder();
		
		// 문자열 끝날 때까지
		for(int i = 0; i < s.length;) {
			
			// 태그, 태그 안의 내용은 바꾸지 않고 그대로 담는다.
			if(s[i] == '<') {
				while(s[i] != '>') {
					sb.append(String.valueOf(s[i]));
					i++;
				}
				// '>'도 넣어줌
				sb.append(String.valueOf(s[i]));
				i++;
			}
			
			// 태그 밖의 문자열을 만났다면, 공백을 기준으로 문자열들 reverse
			else {
				int j = i;
				while(j < s.length && s[j] != ' ' && s[j] != '<') { // 공백이나 '<'를 만날 때까지
					j++;
				}
				for (int k = i; k < j; k++) { // s[i] ~ s[j - 1]까지
					tmp.append(s[k]); // tmp에 넣어서
				}
				tmp.reverse(); // 뒤집어줌
				sb.append(tmp); // 답을 담은 sb에 추가해줌
				tmp.setLength(0); // 임시 StringBuilder 초기화
				i = j; // 인덱스를 가리키는 i 갱신
				
				if(i < s.length && s[i] == ' ') { // 위에서 뒤집어준 문자열 뒤가 공백이었다면 공백도 sb에 추가해줌
					sb.append(s[i]);
					i++;
				}
			}
		}
		
		// 출력
		System.out.println(sb);
	}

}