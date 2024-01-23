import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder answer = new StringBuilder();

        // T := 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        int N, M, dx, horse; int[] cow;
        for (int tc = 1; tc <= T; tc++) {
            // N := 소의 수, M := 말의 수
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // dx := (소의 x좌표 - 말의 x좌표)의 절대값
            st = new StringTokenizer(br.readLine());
            dx = Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));

            // 소의 z좌표
            cow = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                cow[i] = Integer.parseInt(st.nextToken());
            }
            // 정렬
            Arrays.sort(cow);

            // 말의 z좌표를 입력 받으며, 소의 z 좌표 중 가장 가까운 양수값을 찾는다.
            int result = Integer.MAX_VALUE, count = 0, idx;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                horse = Integer.parseInt(st.nextToken());

                // 이분 탐색으로 horse보다 큰 좌표값 중 가장 작은 cow의 좌표 구하기
                idx = binarySearch(horse, cow);

                if(result > Math.abs(horse - cow[idx])) {
                    result = Math.abs(horse - cow[idx]);
                    count = 1;
                } else if(result == Math.abs(horse - cow[idx])) count++;

                // horse보다 작은 좌표값 중 가장 큰 cow의 좌표가 있다면
                if(idx != 0) {
                    if(result > Math.abs(horse - cow[idx - 1])) {
                        result = Math.abs(horse - cow[idx - 1]);
                        count = 1;
                    }
                    else if(result == Math.abs(horse - cow[idx - 1])) count++;
                }
            }

            // 답 저장
            answer.append("#" + tc + " " + (result + dx) + " " + count + "\n");
        }

        System.out.println(answer);
    }

    static private int binarySearch(int num, int[] arr) {

        // 모든 arr에 대해서 num이 더 큰 경우
        if(arr[arr.length - 1] < num) return arr.length - 1;

        // 모든 arr에 대해서 num이 더 작은 경우
        if(arr[0] > num) return 0;

        // arr 중 num보다 큰 수 중 가장 작은 수 구하기
        int s = 0, e = arr.length - 1, m;
        while(s <= e) {
            m = (s + e) / 2;

            if(arr[m] == num) return m;
            else if(arr[m] > num) e = m - 1;
            else s = m + 1;
        }

        return s;

    }
}