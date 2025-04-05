import java.io.*;
import java.util.*;
public class boj_15685_드래곤_커브_250405 {
	static int N;
	static final boolean DEBUG = true;
	static int[] dy = { 0, -1, 0, 1};
	static int[] dx = { 1, 0, -1, 0};
	static final int MX = 105;
	static boolean[][] map = new boolean[MX][MX];
	static class Pos{
		int y, x;
		Pos(int x, int y){
			this.y = y;
			this.x = x;
		}
	}
	static List<Pos> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int t=0; t<N; ++t) {
			 list = new ArrayList<>();
			 String[] input = br.readLine().split(" ");
			 int x = Integer.parseInt(input[0]);
			 int y = Integer.parseInt(input[1]);
			 int dir = Integer.parseInt(input[2]);
			 int gen = Integer.parseInt(input[3]);
			 int nx = x + dx[dir];
			 int ny = y + dy[dir];
			 
			 list.add(new Pos(x, y));
			 list.add(new Pos(nx, ny));
			 map[x][y] = true;
			 map[nx][ny] = true;
			 generate(gen);
		}
		
		int result = 0;
		for(int y=0; y<100; ++y) {
			for(int x=0; x<100; ++x) {
				if(map[x][y] && map[x+1][y] && map[x][y+1] && map[x+1][y+1])
					result++;
			}
		}
		
		System.out.println(result);
	}

	private static void generate(int gen) {
		if(gen == 0) return;
		
		int baseIdx = list.size() - 1;
		Pos basePos = list.get(baseIdx);
		for(int i=baseIdx-1; i>=0; --i) {
			Pos cur = list.get(i);
			int sx =basePos.x -  cur.x;
			int sy = basePos.y - cur.y ;
			Pos next = new Pos(basePos.x + sy, basePos.y - sx);
			map[next.x][next.y] = true;
			list.add(next);
		}
		generate(gen-1);
	}
}
