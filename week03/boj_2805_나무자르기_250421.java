import java.io.*;
import java.util.*;

public class boj_2805_나무자르기_250421 {
	static int N, M;
	static long[] trees;
	static long maxLenTree;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input(br);
		System.out.println(findMaxCutHeight());
	}

	private static long findMaxCutHeight() {
		long min = 1;
		long max = maxLenTree;
		long maxHeight = 0;
		while(min <= max) {
			long mid = (min + max) / 2;
			long cutTreeLen = findCutTreeLen(mid);
			if(cutTreeLen < M) {
				max = mid - 1;
			}else {
				min = mid + 1;
				maxHeight = Math.max(mid, maxHeight);
			}
		}
		return maxHeight;
	}

	private static long findCutTreeLen(long mid) {
		long cutTreeLenSum = 0;
		for(int i=0; i<N; ++i) {
			cutTreeLenSum += trees[i] - mid > 0 ? trees[i] - mid : 0 ;
		}
		return cutTreeLenSum;
	}

	private static void input(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		trees = new long[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; ++i) {
			trees[i] = Long.parseLong(st.nextToken());
			maxLenTree = Math.max(maxLenTree, trees[i]);
		}
	}
}
