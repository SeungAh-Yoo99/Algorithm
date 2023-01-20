import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// m, n 입력
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		// 토마토 정보 입력
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 큐에 오늘 익은 토마토 목록을 넣어두고, 오늘 몇 개의 토마토가 익었는지 count에 넣어둔다.
		// 다음날 count만큼 큐에 있는 토마토를 꺼내서 주변 토마토를 익혀(?)주며 새로 익은 토마토를 넣어준다.
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		int dayCount = -1;
		int count1 = 0;
		int count2 = 0;
		
		// 첫 날 토마토 정보 큐에 넣기
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					qx.add(i);
					qy.add(j);
					count1++;
				}
			}
		}
		
		while(!qx.isEmpty()) {
			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, -1, 1};
			dayCount++;
			
			for(int i = 0; i < count1; i++) {
			
				int x = qx.poll();
				int y = qy.poll();
				
				// 상하좌우로 움직이며 0이면 1로 바꿔주고 큐에 add
				for(int j = 0; j < 4; j++) {
					// 상하좌우가 범위 내인지 확인
					if ((x + dx[j] >= 0 && x + dx[j] < n) && (y + dy[j] >= 0 && y + dy[j] < m)) {
						if(arr[x + dx[j]][y + dy[j]] == 0) {
							arr[x + dx[j]][y + dy[j]] = 1;
							qx.add(x + dx[j]);
							qy.add(y + dy[j]);
							count2++;
						}
					}
				}
				
			}
			
			count1 = count2;
			count2 = 0;
		}
		
		// 모든 토마도가 익었는지 확인
		boolean isSuccess = true;
		for (int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					isSuccess = false;
					break;
				}
			}
			if(isSuccess == false)
				break;
		}
		
		// 토마토가 모두 익지 못하는 상황이면 -1 출력
		if(isSuccess == false)
			System.out.println(-1);
		// 위의 경우가 아니라면 dayCount 출력
		else
			System.out.println(dayCount);
		
	}

}