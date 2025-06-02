import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boj_7576_토마토_250601 {	
	static final int BLANK = -1;
	static final int RAW = 0;
	static final int TOMATO = 1;
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static class Pos{
		int y, x;
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int N, M;
	
	static int[][] map;
	static int[][] vis;
	static int raws = 0;
	static int maxDay = 1;
	static Deque<Pos> dq = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		input(br);
		
		while(!dq.isEmpty()) {
			Pos cur = dq.poll();
			for(int i=0; i<4; ++i) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(!inRange(ny, nx)) continue;
				if(vis[ny][nx] != 0) continue;
				if(map[ny][nx] != RAW) continue;
				dq.offer(new Pos(ny, nx));
				vis[ny][nx] = vis[cur.y][cur.x] + 1;
				raws--;
				maxDay = vis[ny][nx];
			}
		}
		
		if(raws != 0) {
			System.out.println(-1);
		}else {
			System.out.println(maxDay-1);
		}
		
//		int ans = -1;
//		for(int y=0; y<N; ++y) {
//			for(int x=0; x<M; ++x) {
//				if(map[y][x] == RAW && vis[y][x] == 0) {
//					sb.append(-1);
//					print(br, bw, sb);
//					return;
//				}
//				if(map[y][x] != BLANK) {
//					ans = Math.max(ans, vis[y][x]);
//				}
//			}
//		}
//		sb.append(ans-1);
//		print(br, bw, sb);
		
	}

	private static void print(BufferedReader br, BufferedWriter bw, StringBuilder sb) throws IOException {
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static boolean inRange(int y, int x) {
		return 0<=y&&y<N && 0<=x && x<M;
	}


	private static void input(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		vis = new int[N][M];
		
		for(int y=0; y<N; ++y) {
			String[] input = br.readLine().split(" ");
			for(int x=0; x<M; ++x) {
				map[y][x] = Integer.parseInt(input[x]);
				if(map[y][x] == RAW) {
					raws++;
				}
				if(map[y][x] == TOMATO) {
					dq.offer(new Pos(y, x));
					vis[y][x] = 1;
				}
			}
		}
		
	}

}
