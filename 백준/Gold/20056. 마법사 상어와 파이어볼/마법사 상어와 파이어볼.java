import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static class FireBall {
		
		int r;
		int c;
		int m;
		int s;
		int d;
		
		FireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	
	static int N;
	static int M;
	static int K;
	
	static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
	
	static ArrayList<ArrayList<LinkedList<FireBall>>> map;
	
	private static void init() throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			map.add(new ArrayList<>());
			for (int j = 0; j <= N; j++) {
				map.get(i).add(new LinkedList<>());
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map.get(r).get(c).add(new FireBall(r, c, m, s, d));
		}
	}
	
	private static int play() {
		
		int n = 0;
		
		// K번 명령
		while(++n <= K) {
			// 파이어볼 이동
			map = move();
			// 같은 칸에 있는 파이어볼을 하나로 합치고 4개의 파이어볼로 나누기
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if(map.get(i).get(j).size() >= 2) { // 2개 이상의 파이어볼이 있다면
						map.get(i).set(j, sumAndDiv(map.get(i).get(j), i, j));
					}
				}
			}
		}
		
		// 남아있는 파이어볼 질량의 합 출력
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				LinkedList<FireBall> list = map.get(i).get(j);
				for (int k = 0; k < list.size(); k++) {
					result += list.get(k).m;
				}
			}
		}
		
		return result;
	}
	
	private static ArrayList<ArrayList<LinkedList<FireBall>>> move() {
		
		// 임시 map 생성
		ArrayList<ArrayList<LinkedList<FireBall>>> tmpMap = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			tmpMap.add(new ArrayList<>());
			for (int j = 0; j <= N; j++) {
				tmpMap.get(i).add(new LinkedList<>());
			}
		}
		
		// 파이어볼 이동
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				LinkedList<FireBall> list = map.get(i).get(j);
				for (int k = 0; k < list.size(); k++) {
					FireBall fb = list.get(k);
					int nr = getNrc(fb.r, dr[fb.d], fb.s);
					int nc = getNrc(fb.c, dc[fb.d], fb.s);
					
					tmpMap.get(nr).get(nc).add(new FireBall(nr, nc, fb.m, fb.s, fb.d));
				}
			}
		}
		
		return tmpMap;
	}
	
	private static int getNrc(int now, int d, int s) {
		
		int result = now + (d * s);
		
		// 0보다 작은 경우
		while(result <= 0) {
			result += N;
		}
		
		// N보다 클 경우
		while(result > N) {
			result -= N;
		}
		
		return result;
	}
	
	private static LinkedList<FireBall> sumAndDiv(LinkedList<FireBall> list, int r, int c) {
		
		LinkedList<FireBall> result = new LinkedList<>();
		
		int m = 0, s = 0;
		int d = list.get(0).d & 1;
		boolean flag = true; // 파이어볼의 방향이 모두 같을 경우 true
		for (int i = 0; i < list.size(); i++) {
			m += list.get(i).m;
			s += list.get(i).s;
			
			if(d != (list.get(i).d & 1)) flag = false;
		}
		
		m /= 5;
		s /= list.size();
		d = flag ? 0 : 1;
		
		// 질량이 0이 아닐 때만 나누어진 4개의 파이어볼 저장
		if(m != 0) {
			for (int i = 0; i <= 6; i += 2) {
				result.add(new FireBall(r, c, m, s, d + i));
			}
		}
		
		return result;
	}

	public static void main(String[] args) throws Exception{

		// 입력
		init();
		
		// 시뮬레이션 시작
		int result = play();
		
		// 출력
		System.out.println(result);
	}

}