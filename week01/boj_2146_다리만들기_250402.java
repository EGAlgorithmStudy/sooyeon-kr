import java.io.*;
import java.util.*;

public class boj_2146_다리만들기_250402 {
	
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	
	static int[][] landMap;
	static int[][] map;
	static int[][] chk;
	static boolean[][] vis;
	static int N;
	
	static final int SEA = 0;
	static final int LAND = 1;
	
	static int landNum = 0;
	
	static class Pos{
		int y, x;
		
		Pos(int y, int x){
			this.y = y;
			this.x = x;
		}
	}
	static int minBridge = Integer.MAX_VALUE;
	static final boolean DEBUG = true;
	public static void main(String[] args) throws Exception{
		input();
		
		
		for(int y=0; y<N; ++y) {
			for(int x=0; x<N; ++x) {
				if(map[y][x] == SEA) continue;
				if(map[y][x] == LAND && landMap[y][x] != 0) continue;
				landNum++;
				checkLandMap(y, x, landNum);
			}
		}
		
		
		vis = new boolean[N][N];
		int curLandNum = 1;
		for(int y=0; y<N; ++y) {
			if(curLandNum > landNum) break;
			for(int x=0; x<N; ++x) {
				if(landMap[y][x] != curLandNum) continue;
				minBridge = Math.min(checkDist(y, x, curLandNum), minBridge);
				curLandNum++;
			}
		}
		
		
		System.out.println(minBridge);
	}

	private static int checkDist(int y, int x, int curLandNum) {
		Deque<Pos> dq = new ArrayDeque<>();
		vis = new boolean[N][N];
		chk = new int[N][N];
		
		vis[y][x] = true;
		
		dq.offer(new Pos(y, x));
		
		ArrayList<Integer> list = new ArrayList<>();
		while(!dq.isEmpty()) {
			Pos cur = dq.poll();
			
			for(int i=0; i<4; ++i) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(!inRange(ny, nx)) continue;
				if(vis[ny][nx]) continue;
				
				if(map[ny][nx] != SEA && landMap[ny][nx] != curLandNum) {
					list.add(chk[cur.y][cur.x]);
					continue;
				}
				
				if(landMap[ny][nx] == curLandNum) { // 내 섬  
					chk[ny][nx] = 0;
					
				}else if(map[ny][nx] == SEA) {
					chk[ny][nx] = chk[cur.y][cur.x] + 1;
				}
				
				vis[ny][nx] = true;
				dq.offer(new Pos(ny, nx));
			}
		}
		
		Collections.sort(list);
		return list.get(0);
	}

	private static void checkLandMap(int y, int x, int num) {
		
		Deque<Pos> dq = new ArrayDeque<>();
		vis = new boolean[N][N];
		
		landMap[y][x] = num;
		vis[y][x] = true;
		dq.offer(new Pos(y, x));
		
		while(!dq.isEmpty()) {
			Pos cur = dq.poll();
			
			for(int i=0; i<4; ++i) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				if(!inRange(ny, nx)) continue;
				if(map[ny][nx] == SEA) continue;
				if(vis[ny][nx]) continue;
				
				landMap[ny][nx] = num;
				vis[ny][nx] = true;
				dq.offer(new Pos(ny, nx));
			}
		}
	}

	private static void pM(int[][] m) {
		if(DEBUG) {
			for(int y=0; y<N; ++y) {
				for(int x=0; x<N; ++x) {
					System.out.printf("%2d ", m[y][x]);
				}
				p(" ");
			}
		}
	}

	private static void p(String string) {
		if(DEBUG) {
			System.out.println(string);
		}
	}

	private static boolean inRange(int ny, int nx) {
		return 0<= ny && ny <N && 0<= nx && nx <N;
	}

	private static void input() throws Exception{
		System.setIn(new FileInputStream("./src/boj/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		landMap = new int[N][N];
		chk = new int[N][N];
		vis = new boolean[N][N];
		
		for(int y=0; y<N; ++y) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; ++x) {
				map[y][x] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
