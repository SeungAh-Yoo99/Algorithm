import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        Integer[] crane = new Integer[N + 1];
        st = new StringTokenizer(br.readLine());
        crane[0] = 0;
        for (int i = 1; i <= N; i++) {
            crane[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crane, Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());

        Integer[] box = new Integer[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            box[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(box, Collections.reverseOrder());

        // 가장 무거운 박스가 가장 무거운 박스를 옮길 수 있는 크레인의 무게 제한보다 크다면 모든 박스를 옮길 수 없음
        if(box[0] > crane[0]) {
            System.out.println(-1);
            return;
        }

        int b = 0;
        int day = 0, rest = 0, blank = 0;
        int now, tmp;
        for (int c = 0; c < N; c++) {

            now = 0;

            while(b < M && crane[c + 1] < box[b]) {
                now++;
                b++;
            }

            if(now < day) blank += day - now;
            else if(now > day){
                tmp = now - day;

                if(blank >= tmp) {
                    blank -= tmp;
                    continue;
                }
                else {
                    tmp -= blank;
                    blank = 0;
                }

                if(rest >= tmp) rest -= tmp;
                else {
                    tmp -= rest;
                    day += (tmp / (c + 1));
                    if(tmp % (c + 1) != 0) {
                        day += 1;
                        rest = c + 1 - (tmp % (c + 1));
                    }
                }

            }

            if(b == M) break;
        }

        System.out.println(day);
    }
}