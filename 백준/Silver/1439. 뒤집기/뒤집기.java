import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        int count0 = 0; // 0 덩어리 개수
        int count1 = 0; // 1 덩어리 개수

        // 첫 덩어리 확인
        if(S.charAt(0) == '0') count0++;
        else count1++;

        for (int i = 1; i < S.length(); i++) {
            if(S.charAt(i) != S.charAt(i - 1)) {
                if(S.charAt(i) == '0') count0++;
                else count1++;
            }
        }

        // 덩어리 개수가 더 작은 것을 뒤집기0001100
        System.out.println(count0 < count1 ? count0 : count1);
    }
}