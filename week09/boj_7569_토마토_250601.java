import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boj_7569_토마토_250601 {
	static final int BLANK = -1;
	static final int RAW = 0;
	static final int TOMATO = 1;
	
	static int[] dy = {-1, 0, 1, 0, 0, 0};
	static int[] dx = {0, 1, 0, -1, 0, 0};
	static int[] dh = {0, 0, 0, 0, 1, -1};
	
	static class Pos{
		int y, x, h;
		Pos(int h, int y, int x){
			this.y = y;
			this.x = x;
			this.h = h;
		}
	}
	
	static int N, M, H;
	static int[][][] map;
	static int[][][] vis;
	
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
			
			for(int i=0; i<6; ++i) {
		
				int nh = cur.h + dh[i];
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(!inRange(nh, ny, nx)) continue;
				if(map[nh][ny][nx] != RAW) continue;
				if(vis[nh][ny][nx] != 0) continue;
				dq.offer(new Pos(nh, ny, nx));
				vis[nh][ny][nx] = vis[cur.h][cur.y][cur.x] + 1;
				maxDay = vis[nh][ny][nx];
				raws--;
			}
		}
		
		if(raws!=0) {
			sb.append(-1);
		}else {
			sb.append(maxDay-1);
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static boolean inRange(int h, int y, int x) {
		return 0<= h && h<H && 0<=y && y<N && 0<=x && x<M;
	}

	private static void input(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		vis = new int[H][N][M];
		
		for(int h=0; h<H; ++h) {
			for(int y=0; y<N; ++y) {
				String[] input = br.readLine().split(" ");
				for(int x=0; x<M; ++x) {
					map[h][y][x] = Integer.parseInt(input[x]);
					if(map[h][y][x] == TOMATO) {
						dq.offer(new Pos(h, y, x));
						vis[h][y][x] = 1;
					}else if(map[h][y][x] == RAW) {
						raws++;
					}
					
				}
			}
		}
	}

}
