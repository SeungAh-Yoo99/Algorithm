import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int n, k, t, m, i, j, s;
        int[][] teamInfo, score;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            // 팀 정보를 담을 배열
            // teamInfo[i][0] := i번 팀의 팀 번호
            // teamInfo[i][1] := i번 팀의 최종 점수
            // teamInfo[i][2] := i번 팀의 제출 횟수
            // teamInfo[i][3] := i번 팀의 마지막 제출 시간
            teamInfo = new int[n + 1][4];
            for (int l = 1; l <= n; l++) teamInfo[l][0] = l;

            // 팀별 문제 점수
            score = new int[k + 1][n + 1];

            // 로그 정보 입력
            for (int l = 0; l < m; l++) {
                st = new StringTokenizer(br.readLine());
                i = Integer.parseInt(st.nextToken());
                j = Integer.parseInt(st.nextToken());
                s = Integer.parseInt(st.nextToken());

                // 제출 횟수와 마지막 제출 시간 갱신
                teamInfo[i][2]++;
                teamInfo[i][3] = l;

                if(score[j][i] < s) { // 기존의 점수보다 더 높은 점수를 얻었을 경우
                    teamInfo[i][1] += s - score[j][i]; // 기존 점수의 차이만큼 최종 점수에 더해줌
                    score[j][i] = s; // 가장 높은 점수 갱신
                }
            }

            // 정렬
            Arrays.sort(teamInfo, (o1, o2)
                    -> o1[1] == o2[1]
                    ? o1[2] == o2[2]
                    ? o1[3] - o2[3]
                    : o1[2] - o2[2]
                    : o2[1] - o1[1]);

            // 우리 팀 순위 구하기
            for (int l = 0; l < n; l++) {
                if(teamInfo[l][0] == t) {
                    answer.append((l + 1) + "\n");
                    break;
                }
            }
        }

        System.out.print(answer);
    }
}