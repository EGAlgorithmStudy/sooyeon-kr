import java.io.*;
import java.util.*;

public class boj_2206_벽_부수고_이동하기_250512 {
	static final int WALL = 1;
	static final int BLANK = 0;
	static int N, M;
	static int[][] map;
	
	static class Node {
        int y, x, dist;
        boolean broken;

        Node(int y, int x, int dist, boolean broken) {
            this.y = y;
            this.x = x;
            this.dist = dist;
            this.broken = broken;
        }
    }
	public static void main(String[] args) throws Exception{
		
		input();
		int ans = findMinDist();
		System.out.println(ans);
	}

	private static int findMinDist() {
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		boolean[][][] vis = new boolean[N][M][2];
		
		Deque<Node> dq = new ArrayDeque<>();
		dq.offer(new Node(0, 0, 1, false));
		vis[0][0][0] = true;
		
		while(!dq.isEmpty()) {
			Node cur = dq.poll();
			
			if (cur.y == N - 1 && cur.x == M - 1) return cur.dist;
			 
			for(int i=0; i<4; ++i) {
				int ny = cur.y + dy[i];
				int nx = cur.x + dx[i];
				
				if(!inRange(ny, nx)) continue;
				
				if (map[ny][nx] == BLANK && !vis[ny][nx][cur.broken ? 1 : 0]) {
                    vis[ny][nx][cur.broken ? 1 : 0] = true;
                    dq.offer(new Node(ny, nx, cur.dist + 1, cur.broken));
                }
				
				if (map[ny][nx] == WALL && !cur.broken && !vis[ny][nx][1]) {
                    vis[ny][nx][1] = true;
                    dq.offer(new Node(ny, nx, cur.dist + 1, true));
                }
			}
		}
		
		return -1;
	}

	private static boolean inRange(int y, int x) {
		return 0<=y && y<N && 0<=x && x<M;
	}

	private static void input() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		map = new int[N][M];
		for(int y=0; y<N; ++y) {
			input = br.readLine().split("");
			for(int x=0; x<M; ++x) {
				map[y][x] = Integer.parseInt(input[x]);
			}
		}
	}

}
