import java.util.*;

public class Solution {
    public long solution(int[][] land, int P, int Q) {
        
        long up = 0; // 쌓아야 하는 블럭 개수
        long down = 0; // 제거해야 하는 블럭 개수
        
        // land를 1차원 배열로
        int[] landBy1th = new int[land.length * land.length];
        for(int i = 0; i < land.length; i++) {
            for(int j = 0; j < land[i].length; j++) {
                down += land[i][j];
                landBy1th[land.length * i + j] = land[i][j];
            }
        }
        // 1차원 배열로 만든 land 정렬
        Arrays.sort(landBy1th);
        
        // 같은 층을 가진 칸 개수 구하기
        ArrayList<int[]> blockInfo = new ArrayList<>();
        for(int i = 0; i < landBy1th.length; i++) {
            if(blockInfo.size() > 0
               && blockInfo.get(blockInfo.size() - 1)[0] == landBy1th[i]) {
                blockInfo.get(blockInfo.size() - 1)[1]++;
            }
            else {
                blockInfo.add(new int[] {landBy1th[i], 1});
            }
        }
        
        int under = 0; // 기준 높이보다 낮은 칸 개수
        int now = 0; // 기준 높이에 해당하는 칸 개수
        int top = land.length * land.length; // 기준 높이보다 높은 칸 개수
        
        int preHeight = 0; // 이전 기준 높이
        int height;
        
        long answer = Long.MAX_VALUE;
        for(int i = 0; i < blockInfo.size(); i++) {
            
            height = blockInfo.get(i)[0];
            
            // 기준 높이보다 낮은 칸 개수
            under += now;
            // 기준 높이에 해당하는 칸 개수
            now = blockInfo.get(i)[1];
            
            // 기준 높이 변화로 더 쌓아야 하는 블럭 개수 수정
            up += (long)(height - preHeight) * under;
            down -= (long)(height - preHeight) * top;
            
            answer = Math.min(answer, up * P + down * Q);
            
            // 기준 높이보다 높은 칸 개수
            top -= now;
            
            preHeight = height;
        }

        return answer;
    }
}
