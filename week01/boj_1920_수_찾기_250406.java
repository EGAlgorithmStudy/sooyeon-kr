import java.io.*;
import java.util.*;

public class boj_1920_수_찾기_250406 {
	static int N, M;
	static int[] nums;
	static int[] targets;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		M = Integer.parseInt(br.readLine());
		targets = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	
		Arrays.sort(nums);
		for(int i=0; i<M; ++i) {
			sb.append(binarySearch(targets[i]) == -1 ? "0" : "1").append('\n');
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	private static int binarySearch(int target) {
		int st = 0;
		int ed = nums.length - 1;
		int mid = 0;
		while(st <= ed) {
			mid = (st + ed) / 2;
			if(nums[mid] < target) {
				st = mid + 1;
			}else if(nums[mid] > target) {
				ed = mid - 1;
			}else if(nums[mid] == target){
				return mid;
			}
		}
		return -1;
	}

}
