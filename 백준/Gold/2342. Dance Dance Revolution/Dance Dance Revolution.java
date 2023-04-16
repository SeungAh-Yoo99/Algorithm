import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<Integer> list;
	static int size;
	static int[][][] dp;
	
	private static int move(int idx, int left, int right) {
		
		if(idx == size) return 0;
		
		if(dp[idx][left][right] != 0) return dp[idx][left][right];
		
		int next = list.get(idx);
		return dp[idx][left][right] = Math.min(move(idx + 1, next, right) + getCost(left, next), move(idx + 1, left, next) + getCost(right, next));
	}
	
	private static int getCost(int now, int next) {
		
		if(now == 0) return 2;
		else {
			int f = now - 1 == 0 ? 4 : now - 1;
			int b = now + 1 == 5 ? 1 : now + 1;
			
			// 같은 지점을 누르는 경우
			if(now == next) return 1;
			
			// 인접한 지점으로 움직이는 경우
			if(next == f || next == b) return 3;
			
			// 반대편으로 움직이는 경우
			else return 4;
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) list.add(Integer.parseInt(st.nextToken()));
		size = list.size() - 1;
		
		
		dp = new int[size][5][5];
		
		int result = move(0, 0, 0);
		
		System.out.println(result);
	}

}