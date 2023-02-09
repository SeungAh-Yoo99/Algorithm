import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static char[] str;
	static int[] ACGT = new int[4];
	static int[] acgt = new int[4];
	
	private static void addChr(int idx) {
		if(str[idx] == 'A') acgt[0]++;
		else if(str[idx] == 'C') acgt[1]++;
		else if(str[idx] == 'G') acgt[2]++;
		else acgt[3]++;
	}
	
	private static void subChr(int idx) {
		if(str[idx] == 'A') acgt[0]--;
		else if(str[idx] == 'C') acgt[1]--;
		else if(str[idx] == 'G') acgt[2]--;
		else acgt[3]--;
	}
	
	private static boolean check() {
		for (int j = 0; j < 4; j++) {
			if(ACGT[0] > acgt[0]) return false;
			if(ACGT[1] > acgt[1]) return false;
			if(ACGT[2] > acgt[2]) return false;
			if(ACGT[3] > acgt[3]) return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// S, P 입력
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		// 문자열 입력
		str = br.readLine().toCharArray();
		
		// 문자 최소 개수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		}
		
		// 가능한 개수
		int count = 0;
		
		// 인덱스 0 ~ P - 1까지의 문자열의 문자 갯수 구하고 확인
		for (int i = 0; i < P; i++) {
			addChr(i);
		}
		if(check()) count++;
		
		// 한 칸씩 앞으로 가며 갯수 확인
		for (int i = P; i < S; i++) {
			// 추가해준 문자 개수 + 1
			addChr(i);
			
			// 빼준 문자 개수 - 1
			subChr(i - P);
			
			// 가능 여부 확인
			if(check()) count++;
		}
		
		// 답 출력
		System.out.println(count);
	}

}