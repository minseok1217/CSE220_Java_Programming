package Assignment.Lab05;

public class Point {
	private double x=0 ,y=0;
	
	public Point() {
		this.x = 0;
		this.y = 0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public String toString() {
		return "(" + this.x + 	"," + this.y + ")";
	}

	public double distance(double x, double y) {
		double xDiff = this.x - x;
		double yDiff = this.y - y;
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}

	public double distance(Point another) {
		double xDiff = this.x - another.x;
		double yDiff = this.y - another.y;
		return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
	}
}