import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                answer.append("*");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}