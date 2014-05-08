import java.util.HashMap;

public class MaxPointOnOneLine {

	public static void main(String[] args) {
		Point[][] pointss = {
				{ new Point(0, 0), new Point(0, 1),new Point(0, 0), new Point(0, 1) },
				{ new Point(0, 0), new Point(1, 1),new Point(1, 1), new Point(1, -1), new Point(1, -1) },
				{ new Point(0, 0),new Point(0, 0) },
				{ new Point(84, 250), new Point(0, 0), new Point(1, 0),
						new Point(0, -70), new Point(0, -70), new Point(1, -1),
						new Point(21, 10), new Point(42, 90),
						new Point(-42, -230) } };
		for (Point[] i : pointss) {
			System.out.println(maxPoints(i));
		}
	}

	public static int maxPoints(Point[] points) {
		int maxCountTotal = 0;
		for (Point p1 : points) {
			//max number of points on the line through p1
			int maxCountPerPoint = 0;
			//number of points in p1 position
			int countSamePoint = 0;
			//number of points on the vertical line
			int countInfiSlope = 0;
			//record all existed slope, the line isn't vertical
			//use HashMap to save the number of points with same slope, value is number, key is slope
			HashMap<Float, Integer> slopes = new HashMap<Float, Integer>();
			for (Point p2 : points) {
				//same position points
				if (p1.x == p2.x && p1.y == p2.y) {
					countSamePoint++;
					continue;
				}
				//line is vertical
				if (p1.x == p2.x && p1.y != p2.y) {
					countInfiSlope++;
					continue;
				}
				//line with slope
				//float +/- problem will not induce wrong answer becasue the point in the most edge
				//however we can use add 0.0 to deal this problem
				float k = (float)(p1.y - p2.y) / (float)(p1.x - p2.x);
				if (slopes.containsKey(k)) {
					slopes.put(k, slopes.get(k) + 1);
				} else {
					slopes.put(k, 1);
				}
			}
			//get the max number of points on the line with existed slope
			for (Integer i : slopes.values()) {
				if (i > maxCountPerPoint)
					maxCountPerPoint = i;
			}
			//choose max number of points from slope lines and vertical line
			maxCountPerPoint = Math.max(maxCountPerPoint, countInfiSlope);
			//add up with the points in p1 position
			maxCountPerPoint += countSamePoint;
			if (maxCountTotal < maxCountPerPoint)
				maxCountTotal = maxCountPerPoint;
		}
		return maxCountTotal;
	}
}
