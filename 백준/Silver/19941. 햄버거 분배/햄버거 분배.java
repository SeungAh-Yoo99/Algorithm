import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    // N, K 입력
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    // 사람과 햄버거의 위치 입력
	    char[] arr = br.readLine().toCharArray();
	    
	    int result = 0;
	    for(int i = 0; i < N; i++) {
	    	if(arr[i] == 'P') {
	    		// 햄버거를 먹을 수 있는 범위를 앞에서부터 보며 남아있는 햄버거를 먹는다.
	    		int start = i - K; // 시작 위치
	    		int end = i + K; // 끝 위치
	    		if(start < 0) start = 0; // 범위 체크
	    		if(end >= N) end = N - 1; // 범위 체크
	    		for(int j = start; j <= end; j++) {
	    			if(arr[j] == 'H') { // 햄버거가 있으면
	    				result++;
	    				arr[j] = '0'; // 먹고 '0'으로 바꿔줌
	    				break;
	    			}
	    		}
	    	}
	    }
	    
	    System.out.println(result);
	}
}