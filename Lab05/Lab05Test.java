package Assignment.Lab05;

import java.security.GuardedObject;

public class Lab05Test {
    public static void main(String[] args) {
		 useLine();
		 System.out.println("\n");
		 useTriangle();
		 System.out.println("\n");
		 useQuadrilateral();
		 System.out.println("\n");
        testGeometricObject();
        System.out.println("\n");
		 TestMovableCircle();
		 TestMovableRectangle();
        
	}
    
    public static void TestMovableRectangle() {
    	Movable m1 = new MovableRectangle(0, 0, 50, 50, 10, 10);     // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);
           
        Movable m2 = new MovableRectangle(20, 20, 80, 80, 5, 5); // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);
    }
    
	public static void TestMovableCircle() {
		Movable m1 = new MovablePoint(5, 6, 10, 10);     // upcast
        System.out.println(m1);
        m1.moveLeft();
        System.out.println(m1);
           
        Movable m2 = new MovableCircle(2, 1, 2, 2, 20); // upcast
        System.out.println(m2);
        m2.moveRight();
        System.out.println(m2);
	}
	public static void useLine() {
        Line line1 = new Line(1.0, 1.0, 4.0, 4.0);
        Line line2 = new Line(new Point(2.0, 1.0), new Point(5.0, 6.0));

        System.out.println("Line 1: " + line1.toString());
        System.out.println("Line 2: " + line2.toString());

        double length1 = line1.getLength();
        double length2 = line2.getLength();
        System.out.println("Length of Line 1: " + length1);
        System.out.println("Length of LIne 2: " + length2);
        
        // 인터페이스 테스트
        length1=line1.getArea();
        System.out.println("Area of Line 1: "+length1);
        double l_perimeter= line1.getPerimeter();
        System.out.println("Perimeter of Line 1: "+ l_perimeter);

        // getGradient 메서드 테스트
        double gradient1 = line1.getGradient();
        double gradient2 = line2.getGradient();
        System.out.println("Tangent of Line 1: " + gradient1);
        System.out.println("Tangent of Line 2: " + gradient2);

        Line line3 = new Line(1.0, 1.0, 2.0, 2.0);
        Line line4 = new Line(3.0, 3.0, 4.0, 4.0);
        Point intersection1 = line1.intersectAt(line3);
        Point intersection2 = line1.intersectAt(line4);
        System.out.println("Intersection with Line 3: " + intersection1);
        System.out.println("Intersection with Line 4: " + intersection2);

        Point intersection3 = line1.intersectAt(line2);
        System.out.println("Intersection with Line 2: " + intersection3);

        Point center1 = line1.getCenter();
        Point center2 = line2.getCenter();
        System.out.println("Center of Line 1: " + center1);
        System.out.println("Center of LIne 2: " + center2);
    }
	
	public static void useTriangle() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(3, 0);
        Point p3 = new Point(0, 4);

        Triangle triangle = new Triangle(p1, p2, p3);

        System.out.println("Triangle: " + triangle.toString());

        String type = triangle.getType();
        System.out.println("Triangle Type: " + type);
        
        double perimeter = triangle.getPerimeter();
        System.out.println("Triangle Perimeter: " + perimeter);

        double area = triangle.getArea();
        System.out.println("Triangle Area: " + area);

        Point center = triangle.getCenter();
        System.out.println("Triangle Center: " + center);

        boolean isRight = triangle.isRightTriangle();
        System.out.println("Is Right Triangle? " + isRight);

        boolean isEquilateral = triangle.isEquilateralTriangle();
        System.out.println("Is Equilateral Triangle? " + isEquilateral);

        boolean isAcute = triangle.isAcuteTriangle();
        System.out.println("Is Acute Triangle? " + isAcute);
	}
	
	public static void useQuadrilateral() {
		Point p1 = new Point(1.0, 1.0);
        Point p2 = new Point(4.0, 1.0);
        Point p3 = new Point(5.0, 4.0);
        Point p4 = new Point(2.0, 4.0);

        Quadrilateral quadrilateral = new Quadrilateral(p1, p2, p3, p4);

        System.out.println("Quadrilateral: " + quadrilateral.toString());

        String type = quadrilateral.getType();
        System.out.println("Quadrilateral Type: " + type);

        double perimeter = quadrilateral.getPerimeter();
        System.out.println("Quadrilateral Perimeter: " + perimeter);

        double area = quadrilateral.getArea();
        System.out.println("Quadrilateral Area: " + area);

        Point center = quadrilateral.getCenter();
        System.out.println("Quadrilateral Center: " + center);

        boolean isRectangle = quadrilateral.isRectangle();
        System.out.println("Is Rectangle? " + isRectangle);

        boolean isSquare = quadrilateral.isSquare();
        System.out.println("Is Square? " + isSquare);

        boolean isRhombus = quadrilateral.isRhombus();
        System.out.println("Is Rhombus? " + isRhombus);

        boolean isTrapezoid = quadrilateral.isTrapezoid();
        System.out.println("Is Trapezoid? " + isTrapezoid);
	}
	
    public static void testGeometricObject(){
        GeometricObject[] go = new GeometricObject[5];
        go[0] = new Circle(3.2);
        go[1] = new ResizableCircle(6);
        ResizableCircle c1 = new ResizableCircle(4.0);
        c1.resize(25);
        go[2] = c1;
        ResizableCircle c2 = new ResizableCircle(4.0);
        go[3] = c2;
        go[4] = new Circle(5.5);
        for(GeometricObject g: go){
            System.out.println("Area : " + g.getArea());
        }
        System.out.println("");
        for(GeometricObject g: go){
            System.out.println("perimeter : " + g.getPerimeter());
        }

    }
	
}

