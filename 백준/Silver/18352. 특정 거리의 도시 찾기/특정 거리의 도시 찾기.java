import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// N, M, K, X 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		// 도로 정보를 넣을 ArrayList
		ArrayList<LinkedList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < N + 1; i++) {
			list.add(new LinkedList<>());
		}
		
		// 도로 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list.get(s).add(e);
		}
		
		// 최단 거리 담을 배열
		int[] minD = new int[N + 1];
		// 최단 거리를 -1로 초기화
		for (int i = 1; i <= N; i++) {
			minD[i] = -1;
		}
		
		// X에서 출발할 수 있는 도시의 정보를 q에 담기
		LinkedList<Integer> start = list.get(X);
		
		int count = 0; // X에서 count만큼 이동
		minD[X] = 0; // 시작 도시의 최단 거리는 0
		while(count <= K) {
			count++;
			
			LinkedList<Integer> next = new LinkedList<>();
			for (int i = 0; i < start.size(); i++) {
				if(minD[start.get(i)] == -1) { // 처음 도착한 도시라면
					minD[start.get(i)] = count; // 최단 거리 저장
					next.addAll(list.get(start.get(i)));
				}
			}

			start = next;
		}
		
		// 최소 거리가 K이면 sb에 담아줌
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if(minD[i] == K) {
				sb.append(i + "\n");
				cnt++;
			}
		}
		
		// 출력
		if(cnt == 0) System.out.println("-1");
		else System.out.println(sb);
	}

}