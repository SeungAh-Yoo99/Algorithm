import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[4][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] ab = new int[n * n]; // a, b 합친 값을 넣을 배열
		int[] cd = new int[n * n]; // c, d 합친 값을 넣을 배열
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ab[n * i + j] = arr[0][i] + arr[1][j];
				cd[n * i + j] = arr[2][i] + arr[3][j];
			}
		}
		
		// 두 배열 정렬
		Arrays.sort(ab);
		Arrays.sort(cd);
		
		// 투 포인터로 ab, cd 합이 0인 것을 찾는다
		int start = 0; // ab의 앞부분부터 가리킬 포인터
		int end = cd.length - 1; // cd의 뒷부분부터 가리킬 포인터
		long result = 0;
		while(start < ab.length && end >= 0) { // 두 포인터가 범위를 넘기 전까지
			if(ab[start] + cd[end] > 0) { // 0보다 크면
				end--; // cd의 값을 줄여준다
			}
			else if(ab[start] + cd[end] < 0) { // 0보다 작으면
				start++; // ab의 값을 늘려준다
			}
			else { // ab, cd 합이 0이라면
				long abCount = 1; // ab[start]와 같은 수의 개수를 구한다
				long cdCount = 1; // cd[end]와 같은 수의 개수를 구한다
				while(start < ab.length - 1 && ab[start] == ab[start + 1]) {
					abCount++;
					start++;
				}
				while(end > 0 && cd[end] == cd[end - 1]) {
					cdCount++;
					end--;
				}
				result += abCount * cdCount;
				start++;
				end--;
			}
		}
		
		System.out.println(result);
	}

}