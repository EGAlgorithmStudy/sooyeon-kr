import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class boj_2583_영역구하기_250603 {	
	static final int PAPER = 1;
	static final int BLANK = 0;

	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int N, M, K;
	static int[][] map;
	static boolean[][] vis;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		input(br);
		
		List<Integer> areas = new ArrayList<>();
		for(int y=0; y<N; ++y) {
			for(int x=0; x<M; ++x) {
				if(map[y][x] == PAPER) continue;
				if(vis[y][x] == true) continue;
				areas.add(getArea(y, x));
			}
		}
		
		sb.append(areas.size()).append('\n');
		Collections.sort(areas);
		for(int area:areas) {
			sb.append(area).append(' ');
		}
//		areas.stream().map(area -> sb.append(area).append(' '));
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	private static int getArea(int y, int x) {
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {y, x});
		vis[y][x] = true;
		int area = 1;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int cy = cur[0];
			int cx = cur[1];
			
			for(int i=0; i<4; ++i) {
				int ny = cy + dy[i];
				int nx = cx + dx[i];
				if(!inRange(ny, nx)) continue;
				if(map[ny][nx] != BLANK || vis[ny][nx] == true) continue;
				
				dq.offer(new int[] {ny, nx});
				vis[ny][nx] = true;
				area++;
			}
		}
		
		return area;
	}

	private static boolean inRange(int y, int x) {
		return 0<=x && x<M && 0<=y && y<N;
	}

	private static void input(BufferedReader br) throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		vis = new boolean[N][M];
		
		for(int k=0; k<K; ++k) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			for(int y=y1; y<y2; ++y) {
				for(int x=x1; x<x2; ++x) {
					map[y][x] = PAPER;
				}
			}
		}
	}

}
