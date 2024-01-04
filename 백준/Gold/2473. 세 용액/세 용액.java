import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N := 용액의 수
        int N = Integer.parseInt(br.readLine());

        // 용액의 특성값
        long[] price = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            price[i] = Long.parseLong(st.nextToken());
        }

        // 용액의 특성값 오름차순 정렬
        Arrays.sort(price);

        // 작은 값부터 하나의 용액 선택한 후, 다른 두 용액은 투 포인터로 구하기
        long result = Long.MAX_VALUE; // 답에 해당하는 세 용액의 합의 절대값
        long a = 0, b = 0, c = 0; // 답에 해당하는 세 용액
        
        long tmp; int s, e;
        for (int i = 0; i < N; i++) {
            s = i + 1;
            e = N - 1;

            while (s < e) {

                tmp = price[i] + price[s] + price[e];

                if(tmp < 0) { // 세 용액의 합이 음수일 경우
                    if(result > tmp * -1) { // 더 작은 절대값을 찾았다면
                        result = tmp * -1;
                        a = price[i];
                        b = price[s];
                        c = price[e];
                    }
                    s++;
                } else { // 세 용액의 합이 양수일 경우
                    if(result > tmp) { // 더 작은 절대값을 찾았다면
                        result = tmp;
                        a = price[i];
                        b = price[s];
                        c = price[e];
                    }
                    e--;
                }
            }
        }

        // 출력
        System.out.println(a + " " + b + " " + c);
    }
}
