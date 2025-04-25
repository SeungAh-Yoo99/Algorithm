class Solution {
    public String solution(String a, String b) {
        
        // a와 b 뒤집어 저장
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        
        StringBuilder answer = new StringBuilder();
        
        // 더 작은 자릿수를 가진 수의 자릿수만큼만 덧셈 수행
        int mod = 0, aa, bb;
        for(int i = 0; i < Math.min(a.length(), b.length()); i++) {
            aa = a.charAt(i) - '0';
            bb = b.charAt(i) - '0';
            
            answer.append((aa + bb + mod) % 10);
            mod = (aa + bb + mod) / 10;
        }
        
        // 더 긴 자릿수를 가진 수를 마저 더해줌
        for(int i = Math.min(a.length(), b.length()); i < a.length(); i++) {
            aa = a.charAt(i) - '0';
            
            answer.append((aa + mod) % 10);
            mod = (aa + mod) / 10;
        }
        for(int i = Math.min(a.length(), b.length()); i < b.length(); i++) {
            bb = b.charAt(i) - '0';
            
            answer.append((bb + mod) % 10);
            mod = (bb + mod) / 10;
        }
        
        // mod가 남아있다면 마저 더해줌
        if(mod != 0) answer.append(mod);
        
        // 뒤집어서 연산을 했기 때문에 다시 뒤집어서 리턴
        return answer.reverse().toString();
    }
}