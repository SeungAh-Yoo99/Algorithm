class Solution {
    public int solution(int[] num_list) {
        
        int odd = 0, even = 0;
        
        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i] % 2 == 0)
                even = even * 10 + num_list[i];
            else
                odd = odd * 10 + num_list[i];
        }
        
        
        int answer = odd + even;
        return answer;
    }
}