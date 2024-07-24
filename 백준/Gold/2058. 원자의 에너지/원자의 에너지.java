import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * A -> B로 변할 수 있는 방법은 한 가지 뿐이라는 점에서 트리인 것을 알 수 있다.
 *
 * N개의 에너지 상태가 주어지므로, 노드는 N개
 * 만약 노드 A에서 양성자 중 하나를 더하거나 빼서 노드 B값이 나오면 두 노드는 간선으로 연결된 것(A->B)
 *
 * 간선으로 연결된 두 개의 노드는 함께 컨테이너에 집어넣을 수 없음
 * DP를 통해 현재 노드를 넣거나 뺀 경우 중 더 나은 경우를 구해야함
 */
public class Main {

    static int M;
    static boolean[] state;
    static int[] energy;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 원자 상태의 개수
        M = Integer.parseInt(st.nextToken()); // 양성자의 개수

        // 원자가 가질 수 있는 에너지 상태
        state = new boolean[1_000_001];
        // 임의로 정한 루트 노드의 값
        int start = 0;
        int n;
        for (int i = 0; i < N; i++) {
            n = Integer.parseInt(br.readLine());

            if(i == 0) start = n;
            state[n] = true;
        }

        // 양성자가 가진 에너지
        energy = new int[M];
        for (int i = 0; i < M; i++) {
            energy[i] = Integer.parseInt(br.readLine());
        }

        // 노드 방문 체크
        visited = new boolean[1_000_001];
        
        int[] result = dfs(start);
        System.out.println(Math.max(result[0], result[1]));
    }

    private static int[] dfs(int now) { // now := 현재 상태

        // a -> b -> c -> b -> a와 같은 순환구조를 막기 위해 방문체크
        visited[now] = true;

        // result[0] := now를 포함했을 경우의 최대값
        // result[1] := now를 포함하지 않았을 경우의 최대값
        int[] result = new int[2];
        result[0] = now;

        int[] tmp;
        for (int i = 0; i < M; i++) {
            // 양성자를 받아들이거나 내쏘아서 만들 수 있는 새로운 원자
            for(int newState : new int[] {now + energy[i], now - energy[i]}) {
                if(newState > 0 && newState < 1_000_001) {
                    if(state[newState] && !visited[newState]) { // 만들 수 있는 상태라면(연결된 노드를 찾았다면)
                        // now의 자식노드인 newState의 최대값부터 구하러감
                        tmp = dfs(newState);
                        // result[0]은 now를 포함했을 경우의 최댓값
                        // now와 연결된 newState를 포함하지 않은 경우만 올 수 있음
                        result[0] += tmp[1];
                        // result[1]은 now를 포함하지 않았을 경우의 최대값
                        // now와 연결된 newState를 포함하건 포함하지 않건 상관없음(둘 중 더 큰 값으로)
                        result[1] += Math.max(tmp[0], tmp[1]);
                    }
                }
            }
        }

        return result;
    }
}
