import java.io.*;
import java.util.*;

public class boj_2110_공유기설치_250421 {
	static int N, C;
	static int[] homes;
	static int maxHome;
	
	
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("./src/algo/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input(br);
		System.out.println(findMaxMinDist());
	}



	private static int findMaxMinDist() {
		int min = 1;
		int max = maxHome;
		int maxDist = 0;
		while(min <= max) {
			int mid = (min + max) / 2;
			int shareCnt = findShareCnt(mid);
			if(shareCnt<C) {
				max = mid - 1;
			}else {
				min = mid + 1;
				maxDist = Math.max(maxDist, mid);
			}
		}
		return maxDist;
	}



	private static int findShareCnt(int dist) {
		int cnt = 1;
		int last = homes[0]; 

	    for (int i = 1; i < N; i++) {
	        if (homes[i] - last >= dist) {
	            cnt++;
	            last = homes[i];
	        }
	    }
		return cnt;
	}



	private static void input(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		homes = new int[N];
		for(int i=0; i<N; ++i) {
			homes[i] = Integer.parseInt(br.readLine());
			maxHome = Math.max(maxHome, homes[i]);
		}
		Arrays.sort(homes);
	}

}
