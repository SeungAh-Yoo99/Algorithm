import java.util.*;

class Solution {
    public int solution(int n, int k) {
        
        // n을 k진수로 변환
        List<Integer> toK = change(n, k);
        
        // 처음 나오는 0과 마지막에 나오는 0 구하기
        int firstZero = -1, lastZero = -1;
        for(int i = 0; i < toK.size(); i++) {
            if(toK.get(i) == 0) {
                firstZero = i;
                break;
            }
        }
        for(int i = toK.size() - 1; i >= 0; i--) {
            if(toK.get(i) == 0) {
                lastZero = i;
                break;
            }
        }
        
        // 조건에 맞는 소수 구하기
        int answer;
        if(firstZero == -1) return isP(toK);
        else return is0P0(toK, firstZero, lastZero) + isP0(toK, firstZero) + is0P(toK, lastZero);
    }
    
    // n을 k진수로 변환
    private List<Integer> change(int n, int k) {
        
        List<Integer> ret = new ArrayList<>();
        
        // n보다 작은 k의 제곱 중 가장 큰 수 찾기
        int max = k;
        while(max * k <= n) max *= k;
        
        // k진수 구하기
        while(n != 0) {
            ret.add(n / max);
            n %= max;
            max /= k;
        }
        
        return ret;
    }
    
    private int is0P0(List<Integer> numList, int firstZero, int lastZero) {
        
        int ret = 0, p = 0;
        for(int i = firstZero + 1; i <= lastZero; i++) {
            if(numList.get(i) == 0) {
                if(isPrime(p)) ret++;
                p = 0;
            }
            
            p = p * 10 + numList.get(i);
        }
        
        return ret;
    }
    
    private int isP0(List<Integer> numList, int firstZero) {
        
        if(firstZero == -1) return 0;
        
        int p = 0;
        for(int i = 0; i < firstZero; i++) {
            p = p * 10 + numList.get(i);
        }
        
        if(isPrime(p)) return 1;
        else return 0;
    }
    
    private int is0P(List<Integer> numList, int lastZero) {
 
        if(lastZero == -1) return 0;
        
        int p = 0;
        for(int i = lastZero + 1; i < numList.size(); i++) {
            p = p * 10 + numList.get(i);
        }
        
        if(isPrime(p)) return 1;
        else return 0;
    }
    
    private int isP(List<Integer> numList) {
        
        long p = 0;
        
        for(int i = 0; i < numList.size(); i++) {
            p = p * 10 + numList.get(i);
        }
        
        if(isPrime(p)) return 1;
        else return 0;
    }
    
    private boolean isPrime(long n) {
        
        if(n < 2) return false;
        if(n % 2 == 0) return n == 2;

        for(long i = 3; i * i <= n; i += 2)
            if(n % i == 0) return false;
        
        return true;
    }
}