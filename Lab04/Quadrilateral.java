package java_lab4;

public class Quadrilateral extends Point {
    private Point v1, v2, v3, v4;

    public Quadrilateral(Point p1, Point p2, Point p3, Point p4) {
        this.v1 = p1;
        this.v2 = p2;
        this.v3 = p3;
        this.v4 = p4;
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

    public Point getV4() {
        return this.v4;
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

    public void setV4(Point p) {
        this.v4.setX(p.getX());
        this.v4.setY(p.getY());
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
    
    public double getArea() {
        double width = Math.max(Math.abs(v1.getX() - v2.getX()), Math.abs(v3.getX() - v4.getX()));
        double height = Math.max(Math.abs(v1.getY() - v3.getY()), Math.abs(v2.getY() - v4.getY()));
        return width * height;
    }

    public String toString() {
        return "(" + v1.getX() + "," + v1.getY() + "), (" + v2.getX() + "," + v2.getY() + "), (" + v3.getX() + "," + v3.getY() + "), (" + v4.getX() + "," + v4.getY() + ")";
    }

    // 사각형의 유형을 반환하는 메서드 (직사각형, 정사각형, 마름모, 사다리꼴 등)
    public String getType() {
        double side1 = getLength(v1, v2);
        double side2 = getLength(v2, v3);
        double side3 = getLength(v3, v4);
        double side4 = getLength(v4, v1);

        if (side1 == side2 && side2 == side3 && side3 == side4) {
            if (isRectangle()) {
                return "Rectangle";
            } else if (isSquare()) {
                return "Square";
            } else if (isRhombus()) {
                return "Rhombus";
            }
        } else {
            if (isTrapezoid()) {
                return "Trapezoid";
            }
        }

        return "Nothing";
    }

    public double getPerimeter() {
        double side1 = getLength(v1, v2);
        double side2 = getLength(v2, v3);
        double side3 = getLength(v3, v4);
        double side4 = getLength(v4, v1);

        return side1 + side2 + side3 + side4;
    }

    public Point getCenter() {
        double centerX = (v1.getX() + v2.getX() + v3.getX() + v4.getX()) / 4;
        double centerY = (v1.getY() + v2.getY() + v3.getY() + v4.getY()) / 4;

        return new Point(centerX, centerY);
    }

    public boolean isRectangle() {
        double side1 = getLength(v1, v2);
        double side2 = getLength(v2, v3);
        double side3 = getLength(v3, v4);
        double side4 = getLength(v4, v1);

        return (side1 == side3) && (side2 == side4);
    }

    public boolean isSquare() {
        double side1 = getLength(v1, v2);
        double side2 = getLength(v2, v3);
        double side3 = getLength(v3, v4);
        double side4 = getLength(v4, v1);

        return (side1 == side2) && (side2 == side3) && (side3 == side4);
    }

    public boolean isRhombus() {
        double side1 = getLength(v1, v2);
        double side2 = getLength(v2, v3);
        double side3 = getLength(v3, v4);
        double side4 = getLength(v4, v1);

        return (side1 == side2) && (side2 == side3) && (side3 == side4);
    }

    public boolean isTrapezoid() {
        double slope1 = (v2.getY() - v1.getY()) / (v2.getX() - v1.getX());
        double slope2 = (v3.getY() - v2.getY()) / (v3.getX() - v2.getX());
        double slope3 = (v4.getY() - v3.getY()) / (v4.getX() - v3.getX());
        double slope4 = (v1.getY() - v4.getY()) / (v1.getX() - v4.getX());

        return (slope1 == slope3 && slope2 != slope4) || (slope1 != slope3 && slope2 == slope4);
    }
}