import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        // 정렬을 위한 리스트
        List<String> list = new ArrayList<>();
        boolean flag = true; // 배열에 0만 있는지 채크
        for(int i = 0; i < numbers.length; i++) {
            list.add(String.valueOf(numbers[i]));
            if(numbers[i] != 0) flag = false;
        }
        
        // 배열에 0만 있었다면 바로 "0" 리턴
        if(flag) return "0";
        
        // 앞자리 숫자가 큰 순으로 정렬
        Collections.sort(list, (o1, o2) -> {
            
            int o1o2 = Integer.parseInt(o1 + o2);
            int o2o1 = Integer.parseInt(o2 + o1);
            
            return o2o1 - o1o2;
        });
        
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < list.size(); i++) answer.append(list.get(i));
        return answer.toString();
    }
}