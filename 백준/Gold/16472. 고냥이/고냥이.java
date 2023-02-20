import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 알파벳의 종류 최대 개수 N 입력
		int N = Integer.parseInt(br.readLine());
		
		// 문자열 입력
		char[] cat = br.readLine().toCharArray();
		
		int[] include = new int[26]; // 인덱스에 해당하는 문자가 몇 개 포함되어 있는지 표시하는 배열
		int count = 0; // 포함하고 있는 문자열 종류의 수
		int s = 0; // 서브문자열의 시작 인덱스
		int e = 0; // 서브문자열의 끝 인덱스
		int result = 0; // 가장 긴 서브 문자열 길이
		
		while(e < cat.length) {
			
			if(count <= N) { // 포함하고 있는 문자열 종류의 수가 N보다 작으면 문자열을 더 포함할 수 있음
				// 포함하고 있는 문자열 종류가 N보다 작거나 같을 때만 서브 문자열 길이 체크
				result = Math.max(result, e - s); // 현재 서브 문자열의 길이가 가장 큰지 체크
				
				if(include[cat[e] - 'a'] == 0) // 기존에 없던 문자열을 포함한 거라면
					count++; // 포함하고 있는 문자열 종류를 늘려줌
				include[cat[e] - 'a']++; // 인덱스에 해당하는 문자의 개수를 늘려줌
				e++;
			}
			
			else if(count > N) { // 포함하고 있는 문자열 종류의 수가 N보다 같거나 크면, 포함하고 있는 문자열을 줄여주어야 함.
				while(s < e) { // 포함하고 있던 어느 문자열의 포함 개수가 0개가 될 때까지(포함하지 않을 때까지)
					include[cat[s] - 'a']--;
					if(include[cat[s] - 'a'] == 0) {
						count--; // 포함하고 있는 문자열 개수 - 1
						s++;
						break;
					}
					s++;
				}
			}
		}
		
		if(count <= N) // 문자열의 마지막 인덱스를 포함시켰을 때 포함시킨 문자열 종류가 N을 넘지 않았다면
			result = Math.max(result, e - s); // 마지막으로 체크
		
		// 출력
		System.out.println(result);
	}
}