import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[][] A;
    static int[][] step;
    static int[] score;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N := 손동작 수, K := 우승을 위해 필요한 승수
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 상성 정보
        A = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 경희와 민호의 손동작 순서
        step = new int[2][20]; // step[0] := 경희 순서, step[1] := 민호 순서
        for (int i = 0; i < 2; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 20; j++) {
                step[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        score = new int[3]; // 지우, 경희, 민호의 승수
        visited = new boolean[N + 1]; // 지우가 낸 손동작, play 메소드 재귀할 때 사용

        // 확인
        boolean answer = play(0, 0, 0, 1);

        if(answer) System.out.println(1);
        else System.out.println(0);
    }

    private static boolean play(int idx1, int idx2, int p1, int p2) { // idx1 := 경희의 손동작 순서, idx2 := 민호의 손동작 순서, p1, p2 := 이번 판의 순서(0 := 지우, 1 := 경희, 2 := 민우)

        // 지우 vs 경희
        if (p1 == 0 && p2 == 1) {
            for (int i = 1; i <= N; i++) { // 지우가 낼 수 있는 모든 경우 확인
                if(!visited[i]) { // 지우가 안낸 손동작만 낼 수 있음
                    visited[i] = true;

                    if(A[i][step[0][idx1]] == 2) { // 지우 승
                        if(++score[0] == K || play(idx1 + 1, idx2, 0, 2)) { // 지우가 이번 판에서 우승했거나, 이 경우로 다음 판에서 우승한 경우
                            return true;
                        }

                        // 아니라면 이번 판에서 다른 손동작을 내는 경우 확인
                        score[0]--;
                    }
                    else { // 경희 승
                        if(++score[1] != K && play(idx1 + 1, idx2, 1, 2)) { // 경희가 이번 판에서 우승하지 않고, 이 경우로 지우가 다음 판에서 우승한 경우
                            return true;
                        }

                        // 아니라면 이번 판에서 다른 손동작을 내는 경우 확인
                        score[1]--;
                    }

                    visited[i] = false;
                }
            }
        }
        // 지우 vs 민호
        else if(p1 == 0 && p2 == 2) {
            for (int i = 1; i <= N; i++) { // 지우가 낼 수 있는 모든 경우 확인
                if (!visited[i]) { // 지우가 안낸 손동작만 낼 수 있음
                    visited[i] = true;

                    if (A[i][step[1][idx2]] == 2) { // 지우 승
                        if (++score[0] == K || play(idx1, idx2 + 1, 0, 1)) { // 지우가 이번 판에서 우승했거나, 이 경우로 다음 판에서 우승한 경우
                            return true;
                        }

                        // 아니라면 이번 판에서 다른 손동작을 내는 경우 확인
                        score[0]--;
                        
                    } else { // 민호 승
                        if (++score[2] != K && play(idx1, idx2 + 1, 1, 2)) { // 민호가 우승하지 않았고, 이 경우로 다음 판에서 지우가 우승한 경우
                            return true; // 가능한 경우 찾았다면 반복문 탈출
                        }

                        // 아니라면 이번 판에서 다른 손동작을 내는 경우 확인
                        score[2]--;
                    }

                    visited[i] = false;
                }
            }
        }
        // 경희 vs 민호
        else {
            if(A[step[0][idx1]][step[1][idx2]] == 2) { // 경희 승
                if(++score[1] != K && play(idx1 + 1, idx2 + 1, 0, 1)) { // 경희가 이번 판에서 우승하지 않고, 다음 판에서 지우가 우승했다면
                    return true;
                }
                
                // 아니라면 전 단계로 돌아가서 다른 경우 확인
                score[1]--;
                
            } else { // 민호 승
                if(++score[2] != K && play(idx1 + 1, idx2 + 1, 0, 2)) { // 민호가 이번 판에서 우승하지 않고, 다음 판에서 지우가 우승했다면
                    return true;
                }
                
                // 아니라면 전 단계로 돌아가서 다른 경우 확인
                score[2]--;
            }
        }

        return false;
    }
}