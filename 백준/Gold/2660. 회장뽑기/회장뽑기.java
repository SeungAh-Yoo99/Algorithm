import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] level = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(level[i], 51);
            level[i][i] = 0;
        }

        int a, b;
        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1) break;

            level[a][b] = 1;
            level[b][a] = 1;
        }

        // 플로이드-워셜 알고리즘
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    level[j][k] = Math.min(level[j][k], level[j][i] + level[i][k]);
                }
            }
        }

        // 점수 구하기
        int[] score = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                score[i] = Math.max(score[i], level[i][j]);
            }
        }

        int result = Integer.MAX_VALUE;
        Set<Integer> candidate = new HashSet<>();

        for (int i = 1; i <= n; i++) {
            if(result == score[i]) candidate.add(i);
            else if(result > score[i]) {
                candidate.clear();
                candidate.add(i);
                result = score[i];
            }
        }

        ArrayList<Integer> list = new ArrayList<>(candidate);
        Collections.sort(list);

        StringBuilder answer = new StringBuilder();
        answer.append(result + " " + list.size() + "\n");
        for (int i = 0; i < list.size(); i++) {
            answer.append(list.get(i) + " ");
        }
        System.out.println(answer);
    }
}