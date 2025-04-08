import java.io.*;
import java.util.*;

public class boj_5430_AC_250408 {

	static final String ERROR = "error";
	static int T, N;
	static int left, right;
	static boolean isFront = true;
	static int[] nums;
	static String[] cmd;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; ++t) {
			input(br);
			boolean isSuccess = process();
			
			if(!isSuccess) {
				sb.append(ERROR).append('\n');
			}else {
				sb.append(makeArr()).append('\n');
			}
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
		br.close();
		
	}

	private static boolean process() {
		for(int c=0; c<cmd.length; ++c) {
			if("R".equals(cmd[c])) {
				isFront = !isFront;
			}else if("D".equals(cmd[c])) {
				if(left < right) {
					if(isFront) {
						left++;
					}else {
						right--;
					}
				}else {
					return false;
				}
			}
		}
		return true;
	}

	private static void input(BufferedReader br) throws IOException {
		cmd = br.readLine().split("");
		N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		String[] strNums= str.substring(1, str.length()-1).split(",");
		nums = new int[N];
		for(int i=0; i<N; ++i) {
			nums[i] = Integer.parseInt(strNums[i]);
		}
		
		left = 0;
		right = nums.length;
		isFront = true;
	}

	private static String makeArr() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if(isFront) {
			for(int i=left; i<right; ++i) {
				sb.append(nums[i]);
				if(i!=right-1)
					sb.append(",");
			}
		}else {
			for(int i=right-1; i>=left; --i) {
				sb.append(nums[i]);
				if(i!=left)
					sb.append(",");
			}
		}
		sb.append("]");
		return sb.toString();
	}


}
