import java.util.*;

class Solution {
    
    static class Node {
        Map<Character, Node> child;
        Map<Integer, Integer> length;
        
        Node() {
            length = new HashMap<>();
            child = new HashMap<>();
        }
        
        // 자식 노드 추가
        Node add(char c, int l) {
            
            // 뒤 길이가 l만큼 남은 단어가 들어왔다고 알려주기
            length.put(l, length.getOrDefault(l, 0) + 1);
            
            Node ret = child.get(c);
            
            // 자식 노드 중 c가 없는 경우
            if(ret == null) {
                child.put(c, new Node());
                ret = child.get(c);
            }
            
            return ret;
        }
        
        // 현재 노드에서 끝나는 단어가 있다고 알려주기
        void end() {
            length.put(0, length.getOrDefault(0, 0) + 1);
        }
        
        int size(int l) {
            return length.getOrDefault(l, 0);
        }
        
        Node get(char c) {
            return child.get(c);
        }
    }
    
    public int[] solution(String[] words, String[] queries) {
        
        // 단어들을 문자로 나눠 트리 형태로 저장(앞에서 부터)
        Node root = new Node();
        // 단어들을 문자로 나눠 트리 형태로 저장(뒤에서 부터)
        Node tail = new Node();

        Node now; char[] arr;
        for(int i = 0; i < words.length; i++) {
            arr = words[i].toCharArray();
            
            // 단어의 앞에서부터 문자들을 트리 형태로 저장
            now = root;
            for(int j = 0; j < arr.length; j++) {
                now = now.add(arr[j], arr.length - j);
            }
            now.end();
            
            // 단어의 뒤에서부터 문자들을 트리 형태로 저장
            now = tail;
            for(int j = arr.length - 1; j >= 0; j--) {
                now = now.add(arr[j], j + 1);
            }
            now.end();
        }
        
        // 쿼리에 해당하는 단어 개수 찾기
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            
            arr = queries[i].toCharArray();
            
            // 접두사에 와일드 카드가 붙었다면
            if(arr[0] == '?') {
                // 뒤에서부터 찾기
                now = tail;
                
                for(int j = arr.length - 1; j >= 0; j--) {
                    // 뒤에서부터 검색해서 와일드 카드가 있는 곳까지 왔다면
                    if(arr[j] == '?') {
                        answer[i] = now.size(j + 1); // 연결되어 있는 단어 개수 저장
                        break;
                    }
                    now = now.get(arr[j]);
                    
                    // 더 이상 연결된 단어가 없다면 나가기
                    if(now == null) break;
                }
            }
            // 접미사에 와일드 카드가 붙었다면
            else if(arr[arr.length - 1] == '?') {
                // 앞에서부터 찾기
                now = root;
                
                for(int j = 0; j < arr.length; j++) {
                    // 앞에서부터 검색해서 와일드 카드가 있는 곳까지 왔다면
                    if(arr[j] == '?') {
                        answer[i] = now.size(arr.length - j); // 연결되어 있는 단어 개수 저장
                        break;
                    }
                    now = now.get(arr[j]);
                    
                    // 더 이상 연결된 단어가 없다면 나가기
                    if(now == null) break;
                }
            }
        }
        
        return answer;
    }
}