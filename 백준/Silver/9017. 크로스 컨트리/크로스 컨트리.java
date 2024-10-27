import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int N, s;
        int[] team = new int[201], arr;
        int[][] score;
        int winner, winnerScore, winnerMember5;
        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());

            Arrays.fill(team, 0);

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                team[arr[i]]++;
            }

            // 팀별 점수 구하기
            score = new int[201][3];
            s = 1;
            for (int i = 0; i < N; i++) {
                // 해당 팀의 선수의 수가 여섯이 아닌 경우
                if(team[arr[i]] < 6) continue;

                if(score[arr[i]][0] < 4) {
                    score[arr[i]][0]++;
                    score[arr[i]][1] += s;
                }
                else if(score[arr[i]][0] == 4) {
                    score[arr[i]][0]++;
                    score[arr[i]][2] = s; // 팀에서 다섯 번째로 들어온 선수의 점수
                }

                s++;
            }

            // 우승팀 구하기
            winner = 0; winnerScore = Integer.MAX_VALUE; winnerMember5 = Integer.MAX_VALUE;
            for (int i = 1; i <= 200; i++) {

                // 참여 자격이 없는 팀인 경우
                if(score[i][0] == 0) continue;

                if(winnerScore > score[i][1]) {
                    winner = i;
                    winnerScore = score[i][1];
                    winnerMember5 = score[i][2];
                }
                else if(winnerScore == score[i][1]) {
                    if(winnerMember5 > score[i][2]) {
                        winner = i;
                        winnerScore = score[i][1];
                        winnerMember5 = score[i][2];
                    }
                }
            }

            result.append(winner).append("\n");
        }

        System.out.print(result);
    }
}