class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        StringBuilder sb;
        
        for(int i = 0; i < n; i++) {
            sb = new StringBuilder();
            
            for(int j = 0; j < n; j++) {
                if(arr1[i] % 2 == 0 && arr2[i] % 2 == 0)
                    sb.append(' ');
                else
                    sb.append('#');
                
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            
            answer[i] = sb.reverse().toString();
        }
        
        return answer;
    }
}