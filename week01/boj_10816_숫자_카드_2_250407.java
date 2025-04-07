import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class boj_10816_숫자_카드2_250407 {

	static int N, M;
	static int[] nums;
	static int[] targets;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/boj/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		M = Integer.parseInt(br.readLine());
		targets = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
	
		Arrays.sort(nums);
		for(int i=0; i<M; ++i) {
			int up = upper(targets[i]);
			int low = lower(targets[i]);
			sb.append(up-low).append(' ');
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}
	private static int upper(int target) {
		int st = 0;
		int ed = nums.length;
		int mid = 0;
		while(st < ed) {
			mid = (st + ed) / 2;
			if(nums[mid] <= target) {
				st = mid + 1;
			}else if(nums[mid] > target) {
				ed = mid;
			}
			
		}
		
		return st;
	}
	
	private static int lower(int target) {
		int st = 0;
		int ed = nums.length;
		int mid = 0;
		while(st < ed) {
			mid = (st + ed) / 2;
			if(nums[mid] < target) {
				st = mid + 1;
			}else if(nums[mid] >= target) {
				ed = mid;
			}
		}
		
		return st;
	}
}
