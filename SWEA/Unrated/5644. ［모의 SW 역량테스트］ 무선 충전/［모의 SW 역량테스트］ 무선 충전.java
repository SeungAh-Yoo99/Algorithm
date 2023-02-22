import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	
	static int A;
	static int[] a;
	static int[] b;
	static int[][] bc;
	static int result;
	
	private static void range(int ax, int ay, int bx, int by) {
		//System.out.println(ax + " " + ay + " " + bx + " " + by);
		
		PriorityQueue<int[]> aList = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]); // a가 지나는 bc 리스트
		PriorityQueue<int[]> bList = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]); // b가 지나는 bc 리스트
		
		for (int i = 0; i < A; i++) { // a와 b가 i시간에 접하고 있는 베터리 범위 체크
			if(Math.abs(ax - bc[i][0]) + Math.abs(ay - bc[i][1]) <= bc[i][2]) { // a가 베터리 i의 범위 안에 있다면
				aList.add(new int[] {bc[i][3], i}); // 리스트에 추가해줌
			}
			if(Math.abs(bx - bc[i][0]) + Math.abs(by - bc[i][1]) <= bc[i][2]) { // b가 베터리 i의 범위 안에 있다면
				bList.add(new int[] {bc[i][3], i}); // 리스트에 추가해줌
			}
		}
		
//		while(!aList.isEmpty()) {
//			System.out.println(Arrays.toString(aList.poll()));
//		}
//		System.out.println();
//		while(!bList.isEmpty()) {
//			System.out.println(Arrays.toString(bList.poll()));
//		}
//		System.out.println();System.out.println();
		
		
		if(aList.size() == 0) { // A가 어느 배터리 영역에도 들어가 있지 않을 때
			
			if(bList.size() > 0) { // B는 어느 배터리 영역에 들어가 있다면
				result += bList.poll()[0]; // B만 충전값을 더한다.
			}
			else; // 둘 다 배터리 영역에 들어가 있지 않다면 아무런 연산도 해주지 않음
		}
		
		else { // A가 배터리 영역에 들어가 있을 때
			
			if(bList.size() == 0) { // B가 아무 배터리 영역에 들어가 있지 않다면
				result += aList.poll()[0]; // A만 충전값을 더한다.
			}
			else { // A와 B 둘 다 배터리 영역에 들어가 있을 때
				int[] aMax1 = aList.poll(); // 일단 둘 다 최대값의 충전양을 가진 배터리를 꺼낸다
				int[] bMax1 = bList.poll();
				
				if(aMax1[1] != bMax1[1]) { // 둘이 다른 배터리를 최대 충전양으로 가지고 있다면
					result = result + aMax1[0] + bMax1[0]; // 두 값을 더해준다
				}
				else { // 둘이 같은 배터리를 최대 충전양으로 가지고 있다면
					if(aList.size() == 0) { // a가 이제 충전 가능한 배터리가 없을 때
						if(bList.size() == 0) { // b도 없다면
							result += aMax1[0]; // 두 사람이 같은 충전기를 공유한다
						}
						else { // b는 있다면
							int[] bMax2 = bList.poll();
							result = result + aMax1[0] + bMax2[0]; // a는 첫번째로 많은 충전량의 배터리, b는 두번째로 많은 충전량의 배터리를 사용한다.
						}
					}
					else { // a가 충전 가능한 배터리가 남았을 때
						if(bList.size() == 0) { // b는 없다면
							int[] aMax2 = aList.poll();
							result = result + aMax2[0] + bMax1[0]; // a는 두번째, b는 첫번째 사용
						}
						else { // b도 있다면
							int[] aMax2 = aList.poll();
							int[] bMax2 = bList.poll();
							result = result + aMax1[0] + Math.max(aMax2[0], bMax2[0]); // 첫번째로 충전량이 많았던 배터리를 한 사람이 쓰고, 두번째로 충전량이 많은 배터리 중 더 많은 것을 가진 사람이 그 배터리 사용
						}
						
					}
					
				}
				
			}
			
		}
		
		//System.out.println(result);
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 테스트 케이스 개수 T 입력
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");
			
			// 총 이동 시간 M, BC의 개수 A 입력
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			// 사용자 A의 이동 정보
			st = new StringTokenizer(br.readLine());
			a = new int[M];
			for (int i = 0; i < M; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			
			// 사용자 B의 이동 정보
			st = new StringTokenizer(br.readLine());
			b = new int[M];
			for (int i = 0; i < M; i++) {
				b[i] = Integer.parseInt(st.nextToken());
			}
			
			// BC 정보 입력
			bc = new int[A][4];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i][0] = Integer.parseInt(st.nextToken());
				bc[i][1] = Integer.parseInt(st.nextToken());
				bc[i][2] = Integer.parseInt(st.nextToken());
				bc[i][3] = Integer.parseInt(st.nextToken());
			}
			
			// M시간 동안 a, b 이동
			int ax = 1, ay = 1, bx = 10, by = 10;
			int[] dx = {0, 0, 1, 0, -1};
			int[] dy = {0, -1, 0, 1, 0};
			result = 0;
			range(ax, ay, bx, by);
			for (int i = 0; i < M; i++) {
				// a 이동
				ax += dx[a[i]];
				ay += dy[a[i]];
				// b 이동
				bx += dx[b[i]];
				by += dy[b[i]];
				// 범위 체크
				range(ax, ay, bx, by);
			}
			sb.append(result + "\n");
		}
		
		System.out.println(sb);
	}

}
