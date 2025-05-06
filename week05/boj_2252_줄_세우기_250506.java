import java.io.*;
import java.util.*;

public class boj_2252_줄_세우기_250506 {
	static int N, M;
	static int[] indeg;
	static List<Integer>[] graph;
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
			sb.append(cur).append(' ');
			for(int nx:graph[cur]) {
				indeg[nx]--;
				if(indeg[nx]==0) {
					dq.offer(nx);
				}
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
			st = new StringTokenizer(br.readLine());
			
			int front = Integer.parseInt(st.nextToken());
			int back  = Integer.parseInt(st.nextToken());
			
			graph[front].add(back);
			indeg[back]++;
		}
		
	}

}
