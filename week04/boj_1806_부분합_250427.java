import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
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

        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            sum += arr[right];

            while (sum >= M) {
                ans = Math.min(ans, right - left + 1);
                sum -= arr[left++];
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }


    /* 최적화 전
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
        int ans = 100001;
        int sum = arr[st];

        while(st < N && ed < N) {
        	if(sum < M) {
        		ed++;
        		if(ed == N) break;
        		sum += arr[ed];
        	}else {
        		ans = Math.min(ans, ed - st + 1);
        		sum -= arr[st];
        		st++;
        	}
        }
        
        System.out.println(ans == 100001 ? 0 : ans);
    }
    /*
}
