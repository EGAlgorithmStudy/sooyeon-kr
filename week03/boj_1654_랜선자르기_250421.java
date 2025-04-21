import java.io.*;
import java.util.*;

public class boj_1654_랜선자르기_250421 {
	static int K, N;
	static int[] arr;
	static int maxLen;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		input(br);
		System.out.println(findMaxLAN());
		

	}

	private static long findMaxLAN() {
		long min = 1;
		long max = maxLen;
		long maxLAN = 0;
		while(min <= max) {
			long mid = (min + max) / 2;
			if(cutLAN(mid) < N) {
				max = mid - 1;
			}else {
				min = mid + 1;
				maxLAN = Math.max(mid, maxLAN);
			}
		}
		return maxLAN;
	}

	private static long cutLAN(long mid) {
		long cutCnt = 0;
		for(int i=0; i<K; ++i) {
			cutCnt += (arr[i] / mid);
		}
		return cutCnt;
	}

	private static void input(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[K];
		for(int i=0; i<K; ++i) {
			arr[i] = Integer.parseInt(br.readLine());
			maxLen = Math.max(maxLen, arr[i]);
		}
	}
}
