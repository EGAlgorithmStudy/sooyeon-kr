import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class boj_2623_음악프로그램_250506{
	static int N, M;
	static int[] indeg;
	static List<Integer>[] graph;
	static List<Integer> ans = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		input();
		
		Deque<Integer> dq = new ArrayDeque<>();
		for(int i=1; i<=N; ++i) {
			if(indeg[i]==0) dq.offer(i);
		}
		
		while(!dq.isEmpty()) {
			int cur = dq.poll();
			ans.add(cur);
			for(int nx:graph[cur]) {
				indeg[nx]--;
				if(indeg[nx]==0) {
					dq.offer(nx);
				}
			}
		}
		
		if(ans.size() != N) {
			sb.append(0);
		}else {
			for(int answer : ans) {
				sb.append(answer).append('\n');
			}
		}
		
		bw.write(sb.toString());
		bw.close();

	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N+1];
		for(int i=0; i<N+1; ++i) graph[i] = new ArrayList<>();
		
		indeg = new int[N+1];
		
		for(int i=0; i<M; ++i) {
			String[] order = br.readLine().split(" ");
			int[] orders = Stream.of(order).mapToInt(Integer::parseInt).toArray();
		
			for(int j=1; j<orders.length-1; ++j) {
				int front = orders[j];
				int back = orders[j+1];
				
				graph[front].add(back);
				indeg[back]++;
			}
		}
	}

}
