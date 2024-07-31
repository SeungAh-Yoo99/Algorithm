class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int count = 0; // 열린 괄호 개수
        
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            // 열린 괄호인 경우
            if(arr[i] == '(') count++;
            // 닫힌 괄호인 경우
            else {
                if(count == 0) { // 열려있는 괄호가 없다면 올바르지 않은 괄호
                    answer = false;
                    break;
                }
                count--;
            }
        }
        
        // 괄호가 다 닫히지 않았다면 올바르지 않은 괄호
        if(count != 0) answer = false;

        return answer;
    }
}