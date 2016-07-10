import java.util.Arrays;

public class RenderCalendar {
	public static int maxEvents (Line[] array){
		Point[] points = new Point[array.length*2];
		int i = 0;
		for (Line line : array){
			Point p1 = new Point(true,line.start);
			Point p2 = new Point(false,line.end);
			points[i] = p1;
			points[i+1] = p2;
			i = i+2;
		}
		Arrays.sort(points);
		int max = 0;
		int count = 0;
		for (Point point : points){
			if (point.isStart){
				count++;
				if (count > max){
					max = count;
				}
			}
			else if (count != 0){
				count--;
			}
		}
		return max;
	}

	public static class Point implements Comparable<Point>{
		boolean isStart;
		int x;

		public Point (boolean isStart, int x){
			this.isStart = isStart;
			this.x = x;
		}

		public int compareTo (Point that){
			if (this.x < that.x){
				return -1;
			}
			if (this.x > that.x){
				return 1;
			}
			return 0;
		}

	}

	public static class Line{
		int start;
		int end;

		public Line (int s, int e){
			start = s;
			end = e;
		}
	}

	public static void main (String[] args){
		Line e1 = new Line(1,5);
		Line e2 = new Line(6,10);
		Line e3 = new Line(11,15);
		Line e4 = new Line(14,15);
		Line e5 = new Line(2,7);
		Line e6 = new Line(8,9);
		Line e7 = new Line(12,15);
		Line e8 = new Line(4,5);
		Line e9 = new Line(9,17);

		Line[] lines = new Line[] {e1,e2,e3,e4,e5,e6,e7,e8,e9};

		System.out.println(maxEvents(lines));

	}

}
