import java.util.*;

class Solution {
    
    LinkedList<Character> list;
    
    public String solution(int n, int t, int m, int p) {
        
        StringBuilder answer = new StringBuilder();
        
        list = new LinkedList<>();
        list.add('0');
        list.add('0');
        
        int now = 1;
        while(list.size() < t * m + 1) {
            change(n, now++);
        }
        
        for(int i = p; i <= t * m; i += m)
            answer.append(list.get(i));
        
        return answer.toString();
    }
    
    private void change(int n, int num) {
        
        int k = 1;
        while(k * n <= num) k *= n;
        
        int tmp;
        while(k != 0) {
            tmp = num / k;
            num %= k;
            k /= n;
            
            if(tmp <= 9) list.add((char)(tmp + '0'));
            else list.add((char)('A' + (tmp - 10)));
        }
    }
}