import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        int maxLength = 0;
        String S = words[0], T = words[1];

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if(words[i].equals(words[j])) break;

                for (int k = 0; k < Math.min(words[i].length(), words[j].length()); k++) {
                    if(words[i].charAt(k) != words[j].charAt(k)) break;
                    if(maxLength < k + 1) {
                        maxLength = k + 1;
                        S = words[i];
                        T = words[j];
                    }
                }
            }
        }

        System.out.println(S + "\n" + T);
    }
}
