import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class boj_7453_합이_0인_네_정수_250415 {
	static final int A = 0;
	static final int B = 1;
	static final int C = 2;
	static final int D = 3;
	
	static int N;
	static int[][] nums;
	static int[] AB, CD;
	static int idx;
     
	static long ans;
	public static void main(String[] args) throws Exception {

		input();
		for(int target:CD) {
            int lower = lower(target);
            int upper = upper(target);
            ans+=(upper - lower);
		}
		System.out.println(ans);
	}

	private static int lower(int target) {
        int left = 0, right = idx;
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (AB[mid] < target) {
            	left = mid + 1;
            } else {
            	right = mid;
            }
        }
        
        return left;
    }

    private static int upper(int target) {
        int left = 0, right = idx;
        while (left < right) {
            int mid = (left + right) / 2;
            
            if (AB[mid] <= target) {
            	left = mid + 1;
            } else {
            	right = mid;
            }
        }
        
        return left;
    }

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		nums = new int[4][N];
		for(int i=0; i<N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			nums[A][i] = Integer.parseInt(st.nextToken());
			nums[B][i] = Integer.parseInt(st.nextToken());
			nums[C][i] = Integer.parseInt(st.nextToken());
			nums[D][i] = Integer.parseInt(st.nextToken());
		}
		
		
		AB = new int[N * N];
		CD = new int[N * N];
		for(int i=0; i<N; ++i) {
            for(int j=0; j<N; j++) {
                AB[idx++]=(nums[A][i] + nums[B][j]);
            }
        }

		idx = 0;
        for(int i=0; i<N; ++i) {
            for(int j=0; j<N; j++) {
                CD[idx++] = ((nums[C][i] + nums[D][j])*-1);
            }
        }
        
        Arrays.sort(AB);
	}
}
