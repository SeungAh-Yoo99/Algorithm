import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// N, M, R 입력
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		// N x M 크기의 배열 선언 & 입력
		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 한 겹 씩 큐에 넣기
		LinkedList<Queue<Integer>> qList = new LinkedList<>(); // 큐를 넣은 리스트
		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		
		int x = 0;
		int y = -1;
		int d = 0;
		int count = 0;
		
		while(count < N * M) {
			if(d == 0) {
				qList.add(new LinkedList<>());
			}
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			Queue<Integer> tmpQ = qList.get(qList.size() - 1);
			
			while(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] != 0) {
				tmpQ.add(arr[nx][ny]);
				arr[nx][ny] = 0;
				x = nx;
				y = ny;
				nx = x + dx[d];
				ny = y + dy[d];
				count++;
			}
			d = (d + 1) % 4;
		}
		
		// 큐에 넣은 수 R만큼 poll & add
		for (int i = 0; i < qList.size(); i++) {
			Queue<Integer> tmpQ = qList.get(i);
			
			for (int j = 0; j < R; j++) {
				tmpQ.add(tmpQ.poll());
			}
		}
		
		// 다시 배열에 넣어주기
		x = 0;
		y = -1;
		d = 0;
		count = 0;
		int qIdx = -1;
		Queue<Integer> tmpQ = null;
		while(count < N * M) {
			if(d == 0) {
				tmpQ = qList.get(++qIdx);
			}
			
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			
			while(nx >= 0 && nx < N && ny >= 0 && ny < M && arr[nx][ny] == 0) {
				arr[nx][ny] = tmpQ.poll();
				x = nx;
				y = ny;
				nx = x + dx[d];
				ny = y + dy[d];
				count++;
			}
			d = (d + 1) % 4;
		}
		
		// 출력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]);
				if(j == M - 1) sb.append("\n");
				else sb.append(" ");
			}
		}
		System.out.println(sb);
	}

}