import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        boolean flag;
        for(int i = 0; i < S.length(); i++) {
            flag = true;
            for (int j = 0; j <= (S.length() - i) / 2; j++) {
                if (S.charAt(i + j) != S.charAt(S.length() - 1 - j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) { // i ~ (S.length() - 1)까지는 팰린드롬
                System.out.println(S.length() + i);
                return;
            }
        }
    }
}