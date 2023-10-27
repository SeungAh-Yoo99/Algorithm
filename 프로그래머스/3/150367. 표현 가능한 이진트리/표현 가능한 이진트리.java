import java.util.*;

class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            
            if(n == 1) { // n이 1이면 아래의 과정을 거치지 않고 바로 다음 답 확인하러
                answer[i] = 1;
                continue;
            }
            
            // n을 이진수 몇 자리 수로 표현 가능한지 구하기
            long temp = 1;
            int cnt = 0;
            while(n >= temp) {
                temp *= 2;
                cnt++;
            }
            
            // 포화이진트리를 만드려면 몇 자리 수로 표현해야 하는지 구하기
            int leng = 1;
            while(cnt >= leng) {
                leng *= 2;
            }

            // 이진수로 표현한 n을 각 자리 수에 맞게 넣기
            int[] node = new int[leng];
            for(int j = 1; j <= leng - 1 - cnt; j++) node[j] = 0; // 포화이진트리를 만들기 위해 추가한 0
            for(int j = leng - 1; j > leng - 1 - cnt; j--) {
                node[j] = (int)(n % 2);
                n /= 2;
            }
            
            
            // 루트노드부터 밑으로 내려가면서 부모 노드가 0이 아닌지 확인
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[] {(leng + 1) / 2, (leng + 1) / 4}); // 현재 노드 번호(지금은 root)와 자식 노드와의 차이
            
            boolean result = true;
            while(!q.isEmpty()) {
                int[] now = q.poll();
                
                if(node[now[0]] == 1) { // 현재가 1이면 자식이 있던 없던 상관없음.
                    if(now[1] != 1) { // 자식 노드와 차이가 1이면 자식 노드는 리프 노드이므로 확인할 필요 없음
                        q.add(new int[] {now[0] - now[1], now[1] / 2}); // 왼쪽 노드
                        q.add(new int[] {now[0] + now[1], now[1] / 2}); // 오른쪽 노드
                    }
                }
                else { // 현재가 0이면 자식이 있으면 안됨.
                    if(node[now[0] - now[1]] == 1 || node[now[0] + now[1]] == 1) { // 자식이 있다면
                        result = false; // 이진트리로 표현 불가능
                        break;
                    }
                    else {
                        if(now[1] != 1) { // 자식 노드와 차이가 1이면 자식 노드는 리프 노드이므로 확인할 필요 없음
                            q.add(new int[] {now[0] - now[1], now[1] / 2}); // 왼쪽 노드
                            q.add(new int[] {now[0] + now[1], now[1] / 2}); // 오른쪽 노드
                        }
                    }
                }
            }
            
            if(result) answer[i] = 1;
            else answer[i] = 0;
            System.out.println();
        }
        
        return answer;
    }
}