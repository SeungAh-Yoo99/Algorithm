import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[100001];
		// 배열을 모두 최대값으로 초기화
		for (int i = 0; i < 100001; i++) {
			arr[i] = (int)10e9;
		}
		
		Queue<Integer> q = new LinkedList<>();
		arr[n] = 0;
		q.add(n);
		while(!q.isEmpty()) {
			int num = q.poll();
			
			// -1칸
			if ((num - 1) >= 0 && (num - 1) < 100001)
				if (arr[num - 1] > arr[num] + 1) {
					arr[num - 1] = arr[num] + 1;
					q.add(num - 1);
				}
			// 1칸
			if ((num + 1) >= 0 && (num + 1) < 100001) 
				if (arr[num + 1] > arr[num] + 1) {
					arr[num + 1] = arr[num] + 1;
					q.add(num + 1);
				}
			// 순간이동
			if ((num * 2) >= 0 && (num * 2) < 100001) 
				if (arr[num * 2] > arr[num] + 1) {
					arr[num * 2] = arr[num] + 1;
					q.add(num * 2);
				}
		}
		System.out.println(arr[k]);
	}

}