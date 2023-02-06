import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// t 입력
		int t = Integer.parseInt(br.readLine());
		for (int test_case = 0; test_case < t; test_case++) {
			// n 입력
			int n = Integer.parseInt(br.readLine());
			// 노드 정보 넣을 배열
			int[] arr = new int[n + 1];
			
			// A, B 입력 후 arr에 입력
			for (int i = 0; i < n - 1; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				arr[b] = a;
			}
			
			// 공통 조상을 구할 두 노드 입력
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			// num1의 조상을 담을 LinkedList
			LinkedList<Integer> list = new LinkedList<>();
			arr[0] = num1;
			int i = 0;
			// 루트 노드를 찾을 때까지 linkedlist에 num1의 조상을 모두 넣는다.
			while(arr[i] != 0) {
				list.add(arr[i]);
				i = arr[i];
			}
			
			// num2의 조상들을 확인하며, list에 있는지 확인한다.
			int result = 0;
			arr[0] = num2;
			i = 0;
			while(arr[i] != 0) {
				if(list.contains(arr[i])) {
					result = arr[i];
					break;
				}
				i = arr[i];
			}
			
			// 출력
			System.out.println(result);
		}
	}

}