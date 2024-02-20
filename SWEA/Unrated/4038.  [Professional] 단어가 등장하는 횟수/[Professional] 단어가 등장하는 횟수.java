import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        char[] B, S;
        int[] s;
        int idx, sIdx, result;
        for (int tc = 1; tc <= T; tc++) {
            B = br.readLine().toCharArray();
            S = br.readLine().toCharArray();

            // S 내의 반복되는 문자를 중복해서 검사하지 않기 위한 전처리 배열
            s = new int[S.length];
            idx = 0;
            for (int i = 1; i < s.length; i++) {
                if(S[idx] == S[i]) idx++;
                else {
                    while(idx != 0) {
                        idx = s[idx - 1];
                        if(S[idx] == S[i]) {
                            idx++;
                            break;
                        }
                    }
                }
                s[i] = idx;
            }

            // B에서 문자열 S 찾기
            sIdx = 0;
            result = 0;
            for (int i = 0; i < B.length; i++) {

                if(S[sIdx] == B[i]) {
                    if(sIdx == S.length - 1) {
                        result++;
                        sIdx = s[sIdx];
                    }
                    else sIdx++;
                }
                else {
                    while(sIdx != 0) {
                        sIdx = s[sIdx - 1];
                        if(S[sIdx] == B[i]) {
                            sIdx++;
                            break;
                        }
                    }
                }
            }

            answer.append("#" + tc + " " + result + "\n");
        }

        System.out.println(answer);
    }
}
