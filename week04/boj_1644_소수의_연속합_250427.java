import java.io.*;
import java.util.*;
import java.util.stream.Stream;
public class boj_1644_소수의_연속합_250427 {
	static final int X = -1;
	static final int O = 1;

    static int N, M;
    static int[] arr;
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        
        arr = new int[N+1];
        arr[0] = arr[1] = X;
        int cnt = 0;
        for(int i=2; i<=N; ++i) {
        	if(arr[i] == X) continue;
        	arr[i] = O;
        	cnt++;
        	prime.add(i);
        	for(int j=2; i*j <= N; ++j) {
        		arr[i*j] = X;
        	}
        }
        
        int[] primes = prime.stream().mapToInt(Integer::intValue).toArray();
        
        int st = 0;
        int ed = 0;
        int sum = primes.length > 0 ? primes[0] : 0;
        int ans = 0;
        
        while(ed<cnt) {
        	if(sum < N) {
        		ed++;
        		if(ed == cnt) break;
        		sum+=primes[ed];
        	}else {
        		if(sum == N) {
        			ans++;
        		}
        		sum -= primes[st];
        		st++;
        	}
        }
        
        System.out.println(ans);
        
    }
}
