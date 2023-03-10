class Solution {
    public int[] solution(int[][] arr) {
        int size = arr.length;
		
		int[] answer = new int[2];
		
		// 압축
		int r = compression(arr, answer, size, 0, 0);
		if(r == 0) answer[0]++;
		else if(r == 1) answer[1]++;
		
        return answer;
    }
    
    private static int compression(int[][] arr, int[] answer, int n, int startX, int startY) {
		
		if(n == 1) {
			return arr[startX][startY];
		}
		
		int[] num = new int[4];
		num[0] = compression(arr, answer, n / 2, startX, startY);
		num[1] = compression(arr, answer, n / 2, startX, startY + n / 2);
		num[2] = compression(arr, answer, n / 2, startX + n / 2, startY);
		num[3] = compression(arr, answer, n / 2, startX + n / 2, startY + n / 2);
		
		// 모두 같은 수면 압축(-1인 경우에는 전 단계에 압축을 실패했다는 뜻이므로 똑같이 -1 리턴)
		if(num[0] == num[1] && num[1] == num[2] && num[2] == num[3]) {
			return num[0];
		}
		else { // 하나라도 다른 값이 있다면(압축 실패)
			for (int i = 0; i < 4; i++) {
				if(num[i] == 0) answer[0]++;
				else if(num[i] == 1) answer[1]++;
			}
			return -1;
		}
	}
}