class Solution {
    public int solution(String t, String p) {
        
        long numP = Long.parseLong(p);
        
        // 앞에서부터 p의 길이 - 1 만큼 자른 수 구하기
        long num = 0;
        for(int i = 0; i < p.length() - 1; i++) {
            num *= 10;
            num += t.charAt(i) - '0';
        }
        
        // 다음 부분 문자열을 구하기 위한 수
        final long MOD = (long) Math.pow(10, p.length() - 1);
        
        int answer = 0;
        
        int index = p.length() - 1;
        while(index < t.length()) {
            num = (num % MOD) * 10 + (t.charAt(index) - '0');
            
            if(num <= numP) answer++;
            
            index++;
        }
            
        return answer;
    }
}