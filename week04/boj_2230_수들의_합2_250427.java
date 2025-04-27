import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class boj_2230_수들의_합2_250427 {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0, sum = 0, st = 0;
        
        for (int ed = 0; ed < N; ed++) {
            sum += arr[ed];
            
            while (sum >= M) {
                if (sum == M) ans++;
                sum -= arr[st++];
            }
        }
        
        System.out.println(ans);
    }

    /* 최적화 이전
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        int st = 0;
        int ed = 0;
        int ans = 0;
        int sum = arr[st];

        while(st < N && ed < N) {
        	if(sum < M) {
        		ed++;
        		if(ed == N) break;
        		sum += arr[ed];
        	}else {
        		if(sum == M) {
        			ans++;
        		}
        		sum -= arr[st];
        		st++;
        	}
        }
        System.out.println(ans);
    }
    
     */
}
