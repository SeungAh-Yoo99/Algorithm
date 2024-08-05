import java.util.*;

class Solution {
    
    static class Node {
        int count;
        char[] string;
        
        Node(int count, char[] string) {
            this.count = count;
            this.string = string;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        int answer = 0;
        
        // target이 words 안에 있는지 확인
        char[] targetArr = target.toCharArray();
        
        // words들을 char[]로 변환
        char[][] wordsArr = new char[words.length][];
        boolean flag;
        int targetIndex = -1;
        for(int i = 0; i < words.length; i++) {
            wordsArr[i] = words[i].toCharArray();
            
            // target의 인덱스 찾기
            flag = true;
            for(int j = 0; j < targetArr.length; j++) {
                if(wordsArr[i][j] != targetArr[j]) flag = false;
            }
            if(flag) targetIndex = i;
        }
        
        // target이 words 안에 없다면 0 return
        if(targetIndex == -1) {
            return answer;
        }
        
        // bfs
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, begin.toCharArray()));
        
        boolean[] visited = new boolean[words.length];
        
        Node now;
        while(!q.isEmpty()) {
            now = q.poll();
            
            for(int i = 0; i < words.length; i++) {
                // 한글자 차이라면 이동 가능
                if(!visited[i] && isConnected(now.string, wordsArr[i])) {
                    // target을 찾았다면
                    if(i == targetIndex) {
                        answer = now.count + 1;
                        return answer;
                    }
                    
                    visited[i] = true;
                    q.add(new Node(now.count + 1, wordsArr[i]));
                }
            }
        }
        
        return 0;
    }
    
    private static boolean isConnected(char[] arr1, char[] arr2) { // arr1과 arr2가 한글자 차이인지 확인
        
        int count = 0; // arr1와 arr2의 다른 글자 수
        
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] != arr2[i]) count++;
        }
        
        if(count == 1) return true;
        else return false;
    }
}