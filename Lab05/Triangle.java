package Assignment.Lab05;

public class Triangle extends Point implements Shape{
   private Point v1,v2,v3;
   
   public Triangle(Point p1,Point p2,Point p3) {
      this.v1=p1;
      this.v2=p2;
      this.v3=p3;
   }
   
   public Point getV1() {
	   return this.v1;
   }
   
   public Point getV2() {
	   return this.v2;
   }
   
   public Point getV3() {
	   return this.v3;
   }
   
   public void setV1(Point p) {
	   this.v1.setX(p.getX());
	   this.v1.setY(p.getY());
   }
   
   public void setV2(Point p) {
	   this.v2.setX(p.getX());
	   this.v2.setY(p.getY());
   }
   
   public void setV3(Point p) {
	   this.v3.setX(p.getX());
	   this.v3.setY(p.getY());
   }
   
   public double getLength(Point p1, Point p2) {
       double dx = p1.getX() - p2.getX();
       double dy = p1.getY() - p2.getY();
       return Math.sqrt(dx * dx + dy * dy);
   }
   
   public double getAngle(Point p1, Point p2, Point p3) {
       double side1 = getLength(p1, p2);
       double side2 = getLength(p2, p3);
       double side3 = getLength(p1, p3);

       // 코사인 법칙
       double cosAngle = (side1 * side1 + side2 * side2 - side3 * side3) / (2 * side1 * side2);
       return Math.toDegrees(Math.acos(cosAngle));
   }

   public boolean isParallel(Point p1, Point p2, Point p3, Point p4) {
       double slope1 = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
       double slope2 = (p4.getY() - p3.getY()) / (p4.getX() - p3.getX());

       return slope1 == slope2;
   }
   
   public String toString() {
       return "(" + v1.getX() + "," + v1.getY() + "), (" + v2.getX() + "," + v2.getY() + "), (" + v3.getX() + "," + v3.getY() + ")";
   }


   public String getType() {
       double side1 = getLength(v1, v2);
       double side2 = getLength(v2, v3);
       double side3 = getLength(v1, v3);

       if (side1 == side2 && side2 == side3) {
           return "equilateral triangle";
       } else if (side1 == side2 || side2 == side3 || side1 == side3) {
           return "isosceles triangle";
       } else {
           return "regular triangle";
       }
   }

   public double getPerimeter() {
       double side1 = getLength(v1, v2);
       double side2 = getLength(v2, v3);
       double side3 = getLength(v1, v3);

       return side1 + side2 + side3;
   }
   
   public double getArea() {
	    double side1 = getLength(v1, v2);
	    double side2 = getLength(v2, v3);
	    double side3 = getLength(v1, v3);
	    double semiPerimeter = (side1 + side2 + side3) / 2;
	    // 헤론의 공식
	    double area = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
	    
	    return area;
	}
   
   public Point getCenter() {
	    double centerX = (v1.getX() + v2.getX() + v3.getX()) / 3;
	    double centerY = (v1.getY() + v2.getY() + v3.getY()) / 3;
	    
	    return new Point(centerX, centerY);
	}
   public boolean isRightTriangle() {
	    // 피타고라스의 정리를 사용하여 직각 삼각형인지 확인
	    double side1 = getLength(v1, v2);
	    double side2 = getLength(v2, v3);
	    double side3 = getLength(v1, v3);

	    boolean isRight = false;

	    if (side1 > side2 && side1 > side3) {
	        isRight = Math.pow(side1, 2) == Math.pow(side2, 2) + Math.pow(side3, 2);
	    } else if (side2 > side1 && side2 > side3) {
	        isRight = Math.pow(side2, 2) == Math.pow(side1, 2) + Math.pow(side3, 2);
	    } else {
	        isRight = Math.pow(side3, 2) == Math.pow(side1, 2) + Math.pow(side2, 2);
	    }

	    return isRight;
	}

	public boolean isEquilateralTriangle() {
	    double side1 = getLength(v1, v2);
	    double side2 = getLength(v2, v3);
	    double side3 = getLength(v1, v3);

	    return side1 == side2 && side2 == side3;
	}
	
	public boolean isAcuteTriangle() {
	    double side1 = getLength(v1, v2);
	    double side2 = getLength(v2, v3);
	    double side3 = getLength(v1, v3);

	    //코사인 법칙
	    double cosA = (side1 * side1 + side2 * side2 - side3 * side3) / (2 * side1 * side2);
	    double cosB = (side2 * side2 + side3 * side3 - side1 * side1) / (2 * side2 * side3);
	    double cosC = (side3 * side3 + side1 * side1 - side2 * side2) / (2 * side3 * side1);

	    //모든 각이 90도보다 작은지 확인
	    double angleA = Math.toDegrees(Math.acos(cosA));
	    double angleB = Math.toDegrees(Math.acos(cosB));
	    double angleC = Math.toDegrees(Math.acos(cosC));

	    return angleA < 90 && angleB < 90 && angleC < 90;
	}
}
