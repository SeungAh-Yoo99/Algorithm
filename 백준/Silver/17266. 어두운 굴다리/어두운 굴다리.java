import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M + 2];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 0에서 처음 가로등이 나오는 곳의 거리
		int maxDis = arr[0];
		
		// 처음 가로등부터 마지막 가로등까지의 간격 중 가장 긴 간격 찾기
		// 가로등 사이의 간격은 왼쪽 가로등과 오른쪽 가로등이 반 씩 비춰줄 수 있기 때문에
		// 간격의 절반만 생각해주면 됨
		for (int i = 1; i < M; i++) {
			// 가로등 사이의 간격이 짝수라면
			if(((arr[i] - arr[i - 1]) & 1) == 0) maxDis = Math.max(maxDis, (arr[i] - arr[i - 1]) / 2);
			// 홀수라면
			else maxDis = Math.max(maxDis, (arr[i] - arr[i - 1]) / 2 + 1);
		}
		
		// 마지막 가로등에서 N까리의 거리
		maxDis = Math.max(maxDis, N - arr[M - 1]);
		
		System.out.println(maxDis);
	}

}