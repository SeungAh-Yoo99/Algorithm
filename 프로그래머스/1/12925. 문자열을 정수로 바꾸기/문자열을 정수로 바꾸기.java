class Solution {
    public int solution(String s) {
        
//         int answer = 0;
        
//         char[] num = s.toCharArray();
//         for(int i = 0; i < num.length; i++) {
            
//             answer *= 10;
            
//             if(i == 0) { // 맨 앞에 부호가 오는지 확인
//                 // 마이너스일 경우에는 다음 자리까지 처리
//                 if(num[i] == '-') {
//                     answer = -1 * (num[i + 1] - '0');
//                     System.out.println(answer);
//                     i++;
//                 }
//                 // 숫자일 경우 저장
//                 else if(num[i] != '+') answer = num[i] - '0';
//                 // 플러스일 경우에는 따로 처리해주지 않음
//             }
//             else {
                
//                 answer += num[i] - '0';
//         }
        
        return Integer.parseInt(s);
    }
}