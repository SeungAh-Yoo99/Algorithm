import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Jewel {
		int w;
		int v;
		
		public Jewel(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Jewel[] jewel = new Jewel[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			jewel[i] = new Jewel(w, v);
		}
		// 보석의 무게에 대해 올림차순, 무게가 같다면 가격 내림차순으로 정렬
		Arrays.sort(jewel, (o1, o2) -> o1.w == o2.w ? o2.v - o1.v : o1.w - o2.w);
		
		int[] bag = new int[K];
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}
		// 가방을 무게에 대해 올림차순으로 정렬
		Arrays.sort(bag);
		
		// 현재 탐색 중인 가방에 넣을 수 있는 보석들을 넣는다.
		PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
		// 다음으로 pq에 넣을 보석 인덱스
		int idx = 0;
		long result = 0;
		for (int i = 0; i < K; i++) {
			
			for (int j = idx; j < N; j++) {
				// 현재 탐색 중인 가방에 넣을 수 없는 보석이라면
				if(jewel[j].w > bag[i]) {
					idx = j;
					break;
				}
				// 넣을 수 있는 보석이라면
				pq.add(jewel[j]);
				
				// 마지막 보석까지 모두 넣었다면
				if(j == N - 1) idx = N;
			}
			
			// 현재 탐색 중인 가방에 넣을 수 있는 보석 중 가장 큰 보석을 꺼내 가방에 넣어줌
			if(!pq.isEmpty()) result += pq.poll().v;
		}
		
		System.out.println(result);
	}

}