import java.util.HashMap;

public class Candy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {
				{ 1, 1, 1 },
				{ 1, 2, 2 },
				{ 3, 2, 1 },
				{ 1, 3, 5 },
				{ 1, 2, 2, 2, 3 },
				{ 58, 21, 72, 77, 48, 9, 38, 71, 68, 77, 82, 47, 25, 94, 89,
						54, 26, 54, 54, 99, 64, 71, 76, 63, 81, 82, 60, 64, 29,
						51, 87, 87, 72, 12, 16, 20, 21, 54, 43, 41, 83, 77, 41,
						61, 72, 82, 15, 50, 36, 69, 49, 53, 92, 77, 16, 73, 12,
						28, 37, 41, 79, 25, 80, 3, 37, 48, 23, 10, 55, 19, 51,
						38, 96, 92, 99, 68, 75, 14, 18, 63, 35, 19, 68, 28, 49,
						36, 53, 61, 64, 91, 2, 43, 68, 34, 46, 57, 82, 22, 67,
						89 } };
		// int[][] test = {{1,2,1}, { 14, 18, 63, 35, 19, 68, 28 } };
		 
		for (int[] i : test) {
			System.out.println(candy(i));
			System.out.println(candy2(i));
			System.out.println("===============");
		}
	}

	public static int candy(int[] ratings) {
		int n = ratings.length + 2;
		int[] children = new int[n];
		boolean[] label = new boolean[n];
		int[] candy = new int[n];
		int sum = 0;

		children[0] = Integer.MAX_VALUE;
		children[n - 1] = Integer.MAX_VALUE;
		// label[0] = true;
		// label[n - 1] = true;
		candy[0] = 0;
		candy[n - 1] = 0;

		for (int i = 1; i < ratings.length + 1; i++) {
			label[i] = false;
			children[i] = ratings[i - 1];
		}

		for (int i = 1; i < n - 1; i++) {
			int min = Integer.MAX_VALUE;
			int index = 0;
			// find the min rate
			for (int j = 1; j < n - 1; j++) {
				if (children[j] < min && label[j] == false) {
					min = children[j];
					index = j;
				}
			}
			// check two side
			if (label[index - 1] == true && label[index + 1] == true) {
				label[index] = true;
				candy[index] = Math.max(children[index] > children[index - 1] ?candy[index - 1] + 1: 1,
						children[index] > children[index + 1] ?  candy[index + 1] + 1 : 1);

			} else if (label[index - 1] == true && label[index + 1] == false) {
				label[index] = true;
				if (children[index] == children[index - 1]) {
					candy[index] = 1;
				} else {
					candy[index] = candy[index - 1] + 1;
				}
			} else if (label[index + 1] == true && label[index - 1] == false) {
				label[index] = true;
				if (children[index] == children[index + 1]) {
					candy[index] = 1;
				} else {
					candy[index] = candy[index + 1] + 1;
				}
			} else {
				label[index] = true;
				candy[index] = 1;
			}

		}

		for (int i : candy) {
			sum += i;
		}
		return sum;
	}

	public static int candy2(int[] ratings) {
		int people = ratings.length;
		if (people == 0)
			return 0;
		if (people == 1)
			return 1;
		int[] candies = new int[people];

		int first = 0;
		boolean up = false;
		boolean down = false;
		int mid = first;
		int second = first;
		boolean go_on = false;
		int current = 0;
		int next_first = 0;

		do {
			// first = 0;
			candies[first] = 1;
			up = false;
			down = false;
			mid = first;
			second = first;
			current = first;

			while ((++current) < people
					&& ratings[current] > ratings[current - 1]) {
				up = true;
				candies[current] = candies[current - 1] + 1;
			}

			if (current == people) {
				mid = current - 1;
				second = mid;
				down = false;
				go_on = false;
			} else {
				mid = current - 1;

				if (ratings[current] == ratings[current - 1]) {
					down = false;
					second = mid;
					next_first = mid + 1;
					go_on = true;
				} else {
					down = true;
					while ((++current) < people
							&& ratings[current] < ratings[current - 1])
						;
					second = current - 1;
					candies[second] = 1;
					if (current == people) {
						go_on = false;
					} else {
						if (ratings[current] == ratings[current - 1]) {
							second = current;
						}
						go_on = true;
						next_first = second;
					}
				}
			}

			if (down == true) {
				for (int i = second - 1; i > mid; i--) {
					candies[i] = candies[i + 1] + 1;
				}
				if (up == true) {
					candies[mid] = Math.max(candies[mid - 1], candies[mid + 1]) + 1;
				} else {
					candies[mid] = candies[mid + 1] + 1;
				}
			}

			first = next_first;
		} while (go_on);

		int sum = 0;
		for (int i = 0; i < people; i++) {
			sum += candies[i];
		}
		return sum;
	}
	
	public int candy3(int[] ratings) {
	    int[] kids = new int[ratings.length];
	    kids[0] = 1;
	    for (int i = 1; i < ratings.length; i++) {
	        if (ratings[i - 1] < ratings[i]) {
	            kids[i] = kids[i - 1] + 1;
	        } else if (ratings[i - 1] == ratings[i]) {
	            kids[i] = 1;
	        } else {
	            kids[i] = 1;
	            int check = i;
	            //add 
	            while (check > 0 && ratings[check - 1] > ratings[check]
	                    && kids[check - 1] == kids[check]) {
	                kids[check - 1]++;
	                check--;
	            }
	        }
	    }
	    int candy = 0;
	    for (int i = 0; i < kids.length; i++) {
	        candy += kids[i];
	    }
	    return candy;
	}
	


}
