class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        int pre; // 1: aya, 2: ye, 3: woo, 4: ma
        int idx;
        String s;
        for(int i = 0; i < babbling.length; i++) {
            s = babbling[i];
            pre = 0;
            idx = 0;
            
            while(true) {
                if(pre != 1 && s.length() - idx >= 3 
                   && s.substring(idx, idx + 3).equals("aya")) {
                    idx += 3;
                    pre = 1;
                }
                else if(pre != 2 && s.length() - idx >= 2
                        && s.substring(idx, idx + 2).equals("ye")) {
                    idx += 2;
                    pre = 2;
                }
                else if(pre != 3 && s.length() - idx >= 3
                        && s.substring(idx, idx + 3).equals("woo")) {
                    idx += 3;
                    pre = 3;
                }
                else if(pre != 4 && s.length() - idx >= 2
                        && s.substring(idx, idx + 2).equals("ma")) {
                    idx += 2;
                    pre = 4;
                }
                else break;
                
                if(idx == s.length()) {
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}