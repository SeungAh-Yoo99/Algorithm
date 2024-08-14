public class Solution {
    public int solution(int n) {
        
        int ans = 0;
        
        while(n > 0) {
            if(n % 2 == 1) { // 2배 순간이동으로 올 수 없는 위치라면 1칸 이동
                ans++;
                n--;
            }
            else { // 2배 순간이동으로 올 수 있는 위치면 무조건 순간이동
                n /= 2;
            }   
        }
        
        return ans;
    }
}