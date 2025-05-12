import java.io.*;
import java.util.*;

public class boj_16946_벽_부수고_이동하기_4_250512 {
    static final int WALL = 1;
    static final int BLANK = 0;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    static int N, M;
    static int[][] map;
    static int[][] group;
    static int groupNum = 0;
    static Map<Integer, Integer> mapper = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        input();
        
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < M; ++x) {
                if (map[y][x] == BLANK && group[y][x] == 0) {
                    groupNum++;
                    int size = findGroup(y, x, groupNum);
                    mapper.put(groupNum, size);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < N; ++y) {
            for (int x = 0; x < M; ++x) {
                if (map[y][x] == WALL) {
                    sb.append(reWrite(y, x) % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append('\n');
        }
        bw.write(sb.toString());
        bw.close();
    }

    private static int reWrite(int y, int x) {
        int ans = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 4; ++i) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (!inRange(ny, nx))
                continue;
            if (map[ny][nx] == WALL)
                continue;

            int gid = group[ny][nx];
            if (gid > 0) {
                set.add(gid);
            }
        }
        for (Integer g : set) {
            ans += mapper.get(g);
        }
        return ans;
    }

    private static int findGroup(int y, int x, int groupNum) {
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{y, x});
        group[y][x] = groupNum;
        int cnt = 1;

        while (!dq.isEmpty()) {
            int[] cur = dq.poll();
            int cy = cur[0];
            int cx = cur[1];
            for (int i = 0; i < 4; ++i) {
                int ny = cy + dy[i];
                int nx = cx + dx[i];

                if (!inRange(ny, nx))
                    continue;
                if (map[ny][nx] == WALL)
                    continue;
                if (group[ny][nx] != 0)
                    continue;
                dq.offer(new int[]{ny, nx});
                group[ny][nx] = groupNum;
                cnt++;
            }
        }
        return cnt;
    }

    private static boolean inRange(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }

    private static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        group = new int[N][M];
        for (int y = 0; y < N; ++y) {
            String line = br.readLine();
            for (int x = 0; x < M; ++x) {
                map[y][x] = line.charAt(x) - '0';
            }
        }
    }
}
