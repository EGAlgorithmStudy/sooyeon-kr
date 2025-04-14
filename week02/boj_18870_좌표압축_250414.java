import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class boj_18870_좌표압축_250414 {
	static int N;
	static int[] nums;
	public static void main(String[] args) throws Exception{
		
		input();
		
		Set<Integer> set = new TreeSet<Integer>();
		for(int i=0; i<nums.length; ++i) {
			set.add(nums[i]);
		}
		
		int M = set.size();
		int[] sorted = new int[M];
		int j=0;
		for(Integer s:set) {
			sorted[j++] = s; 
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; ++i) {
			sb.append(lower(sorted, nums[i])).append(' ');
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();

	}

	private static int lower(int[] sorted, int target) {
		int left = 0;
		int right = sorted.length;
		while(left < right) {
			int mid = (left + right) / 2;
			if(sorted[mid] < target) {
				left = mid+1;
			}else {
				right = mid;
			}
		}
		return left;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	}

}
