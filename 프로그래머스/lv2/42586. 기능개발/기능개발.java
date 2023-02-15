import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        LinkedList<Integer> list = new LinkedList<>();
        
        // progresses 안의 진도율을 (남은 진도율 / 개발 속도)하여 올림해서 넣어준다.
        for(int i = 0; i < progresses.length; i++) {
            progresses[i] = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
        }
        
        // 현재 progresses 안에는 남은 개발을 완성하는데에 걸리는 일수가 저장되어 있다.
        // 앞의 작업을 완성하는 시간보다 뒤의 작업을 완성하는 시간이 더 적게 걸리면 같이 배로
        for(int i = 0; i < progresses.length;) {
            int count = 1;
            for(int j = i + 1; j < progresses.length; j++) {
                if(progresses[i] >= progresses[j]) {
                    count++;
                }
                else break;
            }
            i += count;
            list.add(count);
        }
        
        // list -> int[]
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}