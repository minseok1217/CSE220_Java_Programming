package Assignment.Lab05;

public class Line extends Point implements Shape{
	private Point begin, end;

	public Line(double x1,double y1,double x2, double y2) {
		begin = new Point(x1, y1); 
		end = new Point(x2, y2);
	}

	public Line(Point begin, Point end) {
		this.begin = begin;
		this.end = end;
	}

	public Point getBegin() {
		return begin;
	}

	public Point getEnd() {
		return end;
	}

	public void setBegin(Point begin) {
		this.begin = begin;
	}

	public void setEnd(Point end) {
		this.end = end;
	}

	public String toString() {
		return  begin + "---->" + end ;
	}

	public double getLength() {
		return begin.distance(end);
	}
	
	public double getGradient() {
		return (this.end.getY()-this.begin.getY())/(this.end.getX()-this.begin.getX());
	}
	
	public Point intersectAt(Line another) {
	    double x1 = this.getBegin().getX();
	    double y1 = this.getBegin().getY();
	    double x2 = this.getEnd().getX();
	    double y2 = this.getEnd().getY();
	    
	    double x3 = another.getBegin().getX();
	    double y3 = another.getBegin().getY();
	    double x4 = another.getEnd().getX();
	    double y4 = another.getEnd().getY();
	    
	    double tangent1=this.getGradient();
	    double tangent2=another.getGradient();

	    // 두 직선이 평행할 떄
	    if (tangent1 == tangent2) {
	        return null;
	    }
	    
	    // 두 선이 교차할 때
	    double x=(y3-y1+tangent1*x1-tangent2*x3)/(tangent1-tangent2);
	    double y=y1+tangent1*(x-x1);
	    
	    // 교차 지점을 나타내는 Point 객체를 생성
	    return new Point(x, y);
	}
	
	public Point getCenter() {
	    double centerX=(this.begin.getX()+this.end.getX()) / 2;
	    double centerY=(this.begin.getY()+this.end.getY()) / 2;
	    return new Point(centerX, centerY);
	}
	
	public double getArea() {
		return 0;
	}
	
	public double getPerimeter() {
		return this.getLength();
	}
}