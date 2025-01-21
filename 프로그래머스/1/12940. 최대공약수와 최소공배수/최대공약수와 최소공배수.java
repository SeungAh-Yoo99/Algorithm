class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);
        
        return answer;
    }
    
    int gcd(int a, int b) { // 최대공약수
        
        int tmp;
        
        if(a < b) {
            tmp = a;
            a = b;
            b = tmp;
        }
        
        while(b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        
        return a;
    }
    
    int lcm(int a, int b) { // 최소 공배수
        
        return (a * b) / gcd(a, b);
    }
}