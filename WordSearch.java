package test;

import java.util.ArrayList;

public class WordSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][][] test1 = {
		// { { 'a', 'a' }, { 'b', 'c' } },
		// { { 'a', 'a','a', 'a','a', 'a','a', 'a','a', 'a','a', 'a','a',
		// 'a','a', 'a','a', 'a' },{ 'a', 'a','a', 'a','a', 'a','a', 'a','a',
		// 'a','a', 'a','a', 'a','a', 'a','a', 'a' } },
		// { { 'c', 'a', 'a' }, { 'a', 'a', 'a' }, { 'b', 'c', 'd' } },
		// { { 'c', 'a', 'a' }, { 'a', 'a', 'a' }, { 'b', 'c', 'd' } },
				{{'a','a'}},
		{
				{ 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
						'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
						'a', 'a', 'a', 'a', 'a', 'a' },
				{ 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a',
						'a', 'a', 'a', 'a', 'a', 'a' } } };
		String[] ts = {
		// "aaa", "aaaaaaaaaaaaaaaaa", "aab", "ab",
				"aaa",
		"aaaaaaaaaaaaaaaaaaaaaaaaa" };
		for (int i = 0; i < test1.length; i++) {
			long startTime = System.nanoTime();
			System.out.println(exist(test1[i], ts[i]));
			long endTime = System.nanoTime();
			System.out.println("程序运行时间exist： " + (endTime - startTime) + "ns");
			System.out.println("-------------");
			long startTime2 = System.nanoTime();
			System.out.println(exist2(test1[i], ts[i]));
			long endTime2 = System.nanoTime();
			System.out.println("程序运行时间exist2： " + (endTime2 - startTime2) + "ns");
			System.out.println("====================");

		}

	}
	
	public static boolean exist(char[][] board, String word) {
		int row = board.length;
		int coloum = board[0].length;
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < coloum; j++) {
				int[][] check = new int[row][coloum];
				if (existImpl(i, j, 0, board, check, word))
					return true;
			}
		}
		return false;
	}

	public static boolean existImpl(int i, int j, int n, char[][] board,
			int[][] check, String word) {
		if (n == word.length() - 1 && board[i][j] == word.charAt(n)) {
			return true;
		}
		if(board[i][j] != word.charAt(n)) return false;
		
		int temp = check[i][j];	
		check[i][j] = 1;
		boolean left = false, right = false, up = false, down = false;			
		if(j > 0 && check[i][j - 1] != 1) {				
			left = existImpl(i, j - 1, n + 1, board, check, word);
		}
		if(!left && j < board[0].length - 1 && check[i][j + 1] != 1) {				
			right = existImpl(i, j + 1, n + 1, board, check, word);
		}
		if(!left && !right && i > 0 && check[i - 1][j] != 1) {				
			up = existImpl(i - 1, j, n + 1, board, check, word);
		}
		if(!left && !right && !up && i < board.length - 1 && check[i + 1][j] != 1) {				
			down = existImpl(i + 1, j, n + 1, board, check, word);
		}
		check[i][j] = temp;
		return right || left || up || down;
	}

	// ===================
	public static boolean exist2(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (dfs(board, word, 0, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	public static boolean dfs(char[][] board, String word, int index, int x,
			int y) {
		if (index == word.length() - 1 && word.charAt(index) == board[x][y]) {
			return true;
		}

		if (word.charAt(index) != board[x][y]) {
			return false;
		}

		char tmp = board[x][y];
		board[x][y] = '.';
		boolean b1 = false, b2 = false, b3 = false, b4 = false;
		if (x - 1 >= 0 && board[x - 1][y] != '.') {
			b1 = dfs(board, word, index + 1, x - 1, y);
		}
		if (!b1 && y - 1 >= 0 && board[x][y - 1] != '.') {
			b2 = dfs(board, word, index + 1, x, y - 1);
		}
		if (!b1 && !b2 && x + 1 < board.length && board[x + 1][y] != '.') {
			b3 = dfs(board, word, index + 1, x + 1, y);
		}
		if (!b1 && !b2 && !b3 && y + 1 < board[0].length
				&& board[x][y + 1] != '.') {
			b4 = dfs(board, word, index + 1, x, y + 1);
		}

		board[x][y] = tmp;
		return b1 || b2 || b3 || b4;
	}
}
