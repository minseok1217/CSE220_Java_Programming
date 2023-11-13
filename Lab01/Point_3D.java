
public class Point_3D{
	private double x = 0.0;
	private double y = 0.0;
	private double z = 0.0;
	
	public void displayPoint() {
		// System.out.println("("+x+","+y+","+z+")");
		// 약간 C에서 쓰는거처럼 ("%d", 1) 이렇게 할 수 있음
		// String.format("(%d, %d, %d), x, y, z")
		System.out.println(String.format("(%f, %f, %f)", x, y, z));
	}
	
	public Point_3D(double x, double y, double z){
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point_3D(){}
	
	public void setcord(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public double getlength() {
		return Math.sqrt(x * x + y * y + z * z);
	}

	public double getdistance(Point_3D p) {
		// Math.pow(x-p.x, 2); // 제곱하는 함수!!!!!
		// return Math.sqrt(((x-p.x)*(x-p.x))+((y-p.y)*(y-p.y))+((z-p.z)*(z-p.z)));
		return Math.sqrt(Math.pow(x - p.x, 2)+Math.pow(y - p.y, 2)+Math.pow(z - p.z, 2));
	}
	
	public void translate(double a, double b, double c) {
		this.x += a;
		this.y += b;
		this.z += c;
	}
}
