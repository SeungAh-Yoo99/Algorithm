import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T := 문자열 게임의 수
        int T = Integer.parseInt(br.readLine());

        StringBuilder result = new StringBuilder();

        char[] W;
        int K, minLength, maxLength;
        for (int t = 0; t < T; t++) {

            W = br.readLine().toCharArray();
            K = Integer.parseInt(br.readLine());

            minLength = -1;
            maxLength = -1;

            int[] start = new int['z' - 'a' + 1]; // 인덱스에 해당하는 문자를 K개 포함할 때, 앞에 있는 문자의 위치
            int[] count = new int['z' - 'a' + 1]; // 인덱스에 해당하는 문자를 현재 몇 개 확인했는지

            for (int i = 0; i < W.length; i++) {

                int c = W[i] - 'a'; // i번째 문자의 인덱스

                count[c]++; // 개수 더함
                if(count[c] == 1) { // c가 처음 나왔다면
                    start[c] = i; // 처음 나온 위치 저장
                }
                if(count[c] == K) { // c가 K개 나왔다면
                    minLength = minLength == -1 ? i - start[c] + 1 : minLength > i - start[c] + 1 ? i - start[c] + 1 : minLength;
                    maxLength = maxLength < i - start[c] + 1 ? i - start[c] + 1 : maxLength;

                    // 답 저장 후 맨 앞의 c를 빼주고 다음 c의 위치 정보 수정
                    for (int j = start[c] + 1; j <= i; j++) {
                        if(W[j] == (char)('a' + c)) {
                            start[c] = j;
                            break;
                        }
                    }
                    count[c]--;
                }

            }

            if(minLength == -1) result.append("-1\n");
            else result.append(minLength + " " + maxLength + "\n");
        }

        System.out.println(result);
    }
}