class Solution {
    public int solution(int[] topping) {
        
        int answer = 0;
        
        // 형과 동생의 각 토핑 개수
        int[] t1 = new int[10_001];
        int[] t2 = new int[10_001];
        
        // 형과 동생의 토핑 가짓수
        int t1Count = 0;
        int t2Count = 0;
        
        // 모든 토핑을 형이 가졌을 때, 각 토핑 개수와 가짓수 구하기
        for(int i = 0; i < topping.length; i++) {
            if(t1[topping[i]] == 0) t1Count++;
            t1[topping[i]]++;
        }
        
        // 하나씩 동생 주기
        for(int i = 0; i < topping.length; i++) {
            if(t1[topping[i]] == 1) t1Count--;
            t1[topping[i]]--;
            
            if(t2[topping[i]] == 0) t2Count++;
            t2[topping[i]]++;
            
            if(t1Count == t2Count) answer++;
        }
        
        return answer;
    }
}