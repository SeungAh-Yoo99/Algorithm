class Solution {
    public String solution(String my_string, int[] indices) {
        
        // 지울 인덱스
        boolean[] delete = new boolean[my_string.length()];
        for(int i : indices) delete[i] = true;
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < my_string.length(); i++)
            if(!delete[i]) answer.append(my_string.charAt(i));
        
        return answer.toString();
    }
}