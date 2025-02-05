class Solution {
    public String[] solution(String[] picture, int k) {
        
        String[] answer = new String[picture.length * k];
        
        StringBuilder tmp;
        for(int i = 0; i < picture.length; i++) {
            
            tmp = new StringBuilder();
            
            for(int j = 0; j < picture[i].length(); j++) {
                for(int l = 0; l < k; l++)
                    tmp.append(picture[i].charAt(j));
            }
            
            for(int j = 0; j < k; j++)
                answer[i * k + j] = tmp.toString();
        }
        
        return answer;
    }
}