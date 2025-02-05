import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);
        
        // 등장하는 숫자 개수가 1개라면, 네 주사위에서 나온 숫자가 모두 p로 같은 경우
        if(map.size() == 1) return 1111 * a;
        if(map.size() == 2) {
            // p 3개, q 1개인 경우
            if(map.get(a) == 1) return (int) Math.pow(10 * b + a, 2);
            if(map.get(b) == 1) return (int) Math.pow(10 * a + b, 2);
            if(map.get(c) == 1) return (int) Math.pow(10 * a + c, 2);
            if(map.get(d) == 1) return (int) Math.pow(10 * a + d, 2);
            // p 2개, q 2개인 경우
            if(a == b) return (a + c) * Math.abs(a - c);
            if(a == c) return (a + b) * Math.abs(a - b);
            if(a == d) return (a + b) * Math.abs(a - b);
        }
        // p 2개, q 1개, r 1개
        if(map.size() == 3) {
            int tmp = 1;
            for(int key : map.keySet()) {
                if(map.get(key) == 1) tmp *= key;
            }
            return tmp;
        }
        // 모두 다른 숫자
        int min = 7;
        for(int key : map.keySet())
            min = Math.min(min, key);
        return min;
    }
}