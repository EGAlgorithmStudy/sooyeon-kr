import java.io.*;
import java.util.*;

public class boj_2230_수_고르기_250427{
    static int N, M, arr[], ans = Integer.MAX_VALUE, st = 0, ed = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        while (st< N && ed < N) {
            int diff = arr[ed] - arr[st];
            if (diff >= M) {
                ans = Math.min(ans, diff);
                st++;
            } else ed++;
        }
        
        System.out.println(ans);

/* 최적화 전 
    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        arr = new int[N];
        for(int i=0; i<N; ++i){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int st = 0;
        int ed = 0;
        int ans = 2147000000;
        while(ed<N && st<N){
            if(arr[ed] - arr[st] < M){
                ed++;
            }else{
                ans = Math.min(ans, arr[ed]-arr[st]);
                st++;
            }
        }
        
        System.out.println(ans);
     */
    }
}