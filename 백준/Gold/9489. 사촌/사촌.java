import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args)  throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder(); // 답 저장 문자열

        while(true) { // 0 0이 입력으로 들어오기 전까지 반복

            // n := 노드의 수, k := 사촌의 수
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if(n == 0 && k == 0) break;

            int[] node = new int[n]; // 노드 정보
            int[] parent = new int[n]; // 부모 노드 인덱스 정보
            int kIdx = 0; // k의 인덱스

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                node[i] = Integer.parseInt(st.nextToken());
                if(node[i] == k) kIdx = i;
            }

            // node[1]부터 부모 노드 인덱스 구하기
            int p = -1;
            parent[0] = -1;
            for (int i = 1; i < n; i++) {
                if(node[i] - 1 == node[i - 1]) { // 전 노드와 부모가 같은 경우
                    parent[i] = p;
                }
                else {
                    parent[i] = ++p;
                }
            }

            // kIdx의 형제 노드 개수 구하기
            int pIdx = parent[kIdx]; // kIdx의 부모 인덱스
            if(pIdx == -1) { // 루트 노드를 구하는 경우엔 바로 구해줌
                result.append(0 + "\n");
                continue;
            }
            int ppIdx = parent[pIdx]; // kIdx의 조부모 인덱스
            int count = 0;
            for (int i = 1; i < n; i++) {
                // kIdx와 조부모 인덱스는 같지만 부모 인덱스는 다른 경우만 구하기
                if(parent[parent[i]] == ppIdx && parent[i] != pIdx) count++;
            }

            result.append(count + "\n");
        }

        // 출력
        System.out.println(result);
    }
}