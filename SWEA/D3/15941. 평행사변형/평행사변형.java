import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        int N;
        for (int tc = 1; tc <= TC; tc++) {
            N = Integer.parseInt(br.readLine());
            System.out.println("#" + tc + " " + (N * N));
        }
    }
}
