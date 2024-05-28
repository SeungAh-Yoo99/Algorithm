import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] len = new int[n + 2];
        for (int i = 0; i < n; i++) {
            len[i] = Integer.parseInt(br.readLine());
        }
        len[n] = 0;
        len[n + 1] = d;

        Arrays.sort(len);

        // 이분 탐색
        int start = 0, end = d, mid;
        int count, left, tmp;
        int result = 0;
        while(start <= end) {
            mid = (start + end) / 2;

           count = 0; left = 0; tmp = 1;
           while(left < n + 1) {

               if(tmp < n + 1 && len[tmp] - len[left] < mid) tmp++;
               else {
                   count += tmp - left - 1;
                   left = tmp++;
               }
           }

           if(count <= m) {
               result = mid;
               start = mid + 1;
           }
           else {
               end = mid - 1;
           }
        }

        System.out.println(result);
    }
}