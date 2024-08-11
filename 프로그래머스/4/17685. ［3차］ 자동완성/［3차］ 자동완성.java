import java.util.*;

class Solution {
    
    static class Node {
        private int length; // 자식 노드의 개수
        private Map<Character, Node> child;
        
        Node() {
            length = 0;
            child = new HashMap<>();
        }
        
        Node add(char c) {
            length++;
            
            Node ret = child.get(c);
            
            if(ret == null) {
                child.put(c, new Node());
                ret = child.get(c);
            }
            
            return ret;
        }
        
        void end() { // 현재 노드에서 끝나는 단어가 있다고 알려주기
            length++;
        }
        
        int size() {
            return length;
        }
        
        Node get(char c) {
            return child.get(c);
        }
    }
    
    public int solution(String[] words) {
        
        // 각 문자들을 Node 객체를 활용하여 트리와 같은 형태로 나타낸다
        Node root = new Node();
        
        char[] arr;
        Node now;
        for(int i = 0; i < words.length; i++) {
            arr = words[i].toCharArray(); // 문자열을 char 배열로 변환
            now = root; // 루트부터 시작
            
            for(int j = 0; j < arr.length; j++) { // 차례로 트리 형태로 만듦
                now = now.add(arr[j]);
            }
            now.end(); // 단어가 끝났다고 알려주기
        }
        
        // 검색 시작
        int answer = 0;
        int length;
        for(int i = 0; i < words.length; i++) {
            arr = words[i].toCharArray(); // 문자열을 char 배열로 변환
            now = root; // 루트부터 시작
            
            // 모든 단어 다 입력한 경우
            answer += arr.length;
            
            for(int j = 0; j < arr.length; j++) {
                now = now.get(arr[j]); // 문자 하나 검색
                length = now.size(); // 현재 문자까지 같은 단어 개수
                
                if(length == 1) { // j번째 문자까지 검색했을 때, 자동 완성 가능
                    answer -= (arr.length - 1) - j; // 입력하지 않은 길이 답에 빼주기
                    break;
                }
            }
        }
        
        return answer;
    }
}