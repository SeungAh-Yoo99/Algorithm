class Solution {
    public long solution(String numbers) {
        
        String[] stringNumbers = new String[] {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        long answer = 0;
        int idx = 0;
        
        while(idx < numbers.length()) {
            
            for(int i = 0; i < 10; i++) {
                if(idx + stringNumbers[i].length() <= numbers.length()
                   && numbers.substring(idx, idx + stringNumbers[i].length()).equals(stringNumbers[i])) {
                    answer = answer * 10 + i;
                    idx += stringNumbers[i].length();
                    break;
                }
            }
        }
        
        return answer;
    }
}