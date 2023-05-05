import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
	
	static int N;
	static String[] arr;
	
	private static String[] merge_sort(int start, int end) {
		
		if(start == end) {
			return new String[] {arr[start]};
		}
		
		int mid = (start + end) / 2;
		String[] left = merge_sort(start, mid);
		String[] right = merge_sort(mid + 1, end);
		
		return merge(left, right);
	}
	
	private static String[] merge(String[] left, String[] right) {
		
		ArrayList<String> ret = new ArrayList<>();
		
		int l = 0, r = 0;
		
		while(l < left.length || r < right.length) {
			if(l == left.length) {
				ret.add(right[r++]);
			}
			else if(r == right.length) {
				ret.add(left[l++]);
			}
			else {
				int v = compare(left[l], right[r]);
				if(v == 0) {
					ret.add(left[l++]);
					r++;
				}
				else if(v == 1) {
					ret.add(left[l++]);
				}
				else {
					ret.add(right[r++]);
				}
			}
		}
		
		return ret.toArray(new String[ret.size()]);
	}
	
	private static int compare(String left, String right) {
		int ret = 0;
		// 0 = 똑같은 이름일 경우
		// 1 = left가 더 앞인 경우
		// 2= right가 더 앞인 경우
		
		if(left.equals(right)) {
			ret = 0;
		}
		else if(left.length() < right.length()){
			ret = 1;
		}
		else if(left.length() > right.length()) {
			ret = 2;
		}
		else {
			char[] l = left.toCharArray();
			char[] r = right.toCharArray();
			for (int i = 0; i < left.length(); i++) {
				if(l[i] > r[i]) {
					ret = 2;
					break;
				}
				else if(l[i] < r[i]) {
					ret = 1;
					break;
				}
			}
		}
		
		return ret;
	}

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder result = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			result.append("#").append(tc).append("\n");
			
			N = Integer.parseInt(br.readLine());
			
			arr = new String[N];
			for (int i = 0; i < N; i++) {
				arr[i] = br.readLine();
			}
			
			String[] v = merge_sort(0, N - 1);
			for (int i = 0; i < v.length; i++) {
				result.append(v[i]).append("\n");
			}
		}
		
		System.out.println(result);
	}

}