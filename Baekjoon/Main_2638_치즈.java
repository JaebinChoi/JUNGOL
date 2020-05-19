import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
	static int R, C, time;
	static int[][] map, temp;
	static int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static ArrayList<Node> list = new ArrayList<>();

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			temp = new int[R][C];
			bfs();

			int size = list.size();
			if (size == 0) break;

			for (int i = 0; i < size; i++) {
				Node node = list.get(i);
				map[node.x][node.y] = 0;
			}

			time++;
			list.clear();
		}
		System.out.println(time);
	}

	private static void bfs() {
		LinkedList<Node> queue = new LinkedList<>();
		boolean[][] visited = new boolean[R][C];
		visited[0][0] = true;
		queue.offer(new Node(0, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nr = node.x + dir[i][0];
				int nc = node.y + dir[i][1];

				if (!isIn(nr, nc) || visited[nr][nc])
					continue;

				if (map[nr][nc] == 1) {
					if (temp[nr][nc] == 1) list.add(new Node(nr, nc));
					else temp[nr][nc]++;
					continue;
				}
				visited[nr][nc] = true;
				queue.offer(new Node(nr, nc));
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nc >= 0 && nr < R && nc < C;
	}
}
