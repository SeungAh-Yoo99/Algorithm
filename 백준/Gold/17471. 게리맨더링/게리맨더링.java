import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] arr;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] group;
	static int visited;
	static int result = Integer.MAX_VALUE;
	
	private static void city(int idx) { // 각 도시별 선거구 나누기
		if(idx == N + 1) { // 마지막 도시까지 선거구를 나눠줬다면
			if(isPossible()) { // 두 개로 나눈 선거구가 가능한 경우라면
				getNumOfPeople(); // 선거구에 포함된 인구의 차이를 구함
			}
			return;
		}
		
		group[idx] = true; // idx 도시를 true 선거구에 포함시키는 경우
		city(idx + 1);
		
		group[idx] = false; // idx 도시를 fasle 선거구에 포함시키는 경우
		city(idx + 1);
	}
	
	private static boolean isPossible() {
		// 각 선거구가 하나의 구역이라도 포함하고 있는지 검사
		int t = 0, f = 0;
		for (int i = 1; i <= N; i++) {
			if(group[i]) t++; // true인 선거구라면 t를
			else f++; // false인 선거구라면 f를 1 씩 증가시켜주어 각 선거구의 도시 개수를 샌다
		}
		if(t < 1 || f < 1) return false; // 두 선거구 모두 하나의 도시라도 포함하지 못했다면 불가능한 방법
		
		// 각 선거구의 구역이 모두 연결되어 있는지 검사
		int fristTrue = -1, fristFalse = -1; // 첫 번째로 나온 true 선거구 지역의 인덱스
		for (int i = 1; i <= N; i++) {
			if(fristTrue == -1 && group[i]) fristTrue = i;
			if(fristFalse == -1 && !group[i]) fristFalse = i;
			if(fristTrue != -1 && fristFalse != -1) break;
		}
		
		visited = 1 << N;
		dfs(fristTrue, true); // dfs로 true 선거구의 지역이 모두 이어져 있는지 검사
		dfs(fristFalse, false);
		
		if((visited & ((1 << N + 1) - 1)) == (1 << N + 1) - 1) return true;
		else return false;
	}
	
	private static void dfs(int start, boolean info) {
		visited = visited | (1 << start - 1);
		
		ArrayList<Integer> startList = list.get(start);
		for (int i = 0; i < startList.size(); i++) {
			if((visited & (1 << (startList.get(i) - 1))) == 0 && group[startList.get(i)] == info)
				dfs(startList.get(i), info);
		}
	}
	
	private static void getNumOfPeople() { // 선거구 인구 차이 구하는 메소드
		int trueCount = 0, falseCount = 0;
		
		for (int i = 1; i <= N; i++) {
			if(group[i]) trueCount += arr[i];
			else falseCount += arr[i];
		}
		
		result = Math.min(result, Math.abs(trueCount - falseCount));
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 구역의 개수
		
		arr = new int[N + 1]; // 구역의 인구
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		list = new ArrayList<>(); // 인접한 구역의 정보
		list.add(new ArrayList<>());
		for (int i = 1; i <= N; i++) {
			list.add(new ArrayList<>());
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		
		group = new boolean[N + 1]; // 각 도시를 true, false로 선거구를 나눈다.
		
		city(1);
		
		if(result == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(result);
	}

}