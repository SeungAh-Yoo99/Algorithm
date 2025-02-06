class Solution {
    public String solution(String my_string, int[][] queries) {
        
        char[] string = my_string.toCharArray();
        
        char tmp;
        for(int i = 0; i < queries.length; i++) {
            for(int j = 0; j <= (queries[i][0] + queries[i][1]) / 2 - queries[i][0]; j++) {
                tmp = string[queries[i][0] + j];
                string[queries[i][0] + j] = string[queries[i][1] - j];
                string[queries[i][1] - j] = tmp;
            }
        }
        
        StringBuilder answer = new StringBuilder();
        for(char c : string) answer.append(c);
        return answer.toString();
    }
}