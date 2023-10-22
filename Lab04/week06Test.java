package java_lab4;

public class week06Test {
	public static void main(String[] args) {
		useLine();
		System.out.println("\n");
		useTriangle();
		System.out.println("\n");
		useQuadrilateral();
		System.out.println("\n");
		
		//useHourlyEmployee();
		//System.out.println("\n");
		//useBaseEmployee();
		//System.out.println("\n");
		//useSalaried();
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
	
	public static void useHourlyEmployee(){
		// HourlyEmployee 객체 생성
        HourlyEmployee employee = new HourlyEmployee("John", "Doe", "123-45-6789", 15.0, 40.0);

        // 시급과 근무 시간 설정
        employee.setWage(20.0);
        employee.setHours(45.0);

        // 정보 출력
        System.out.println("Employee Information:");
        System.out.println("First Name: " + employee.getfirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("Social Security Number: " + employee.getSocialSecurityNumber());
        System.out.println("Hourly Wage: $" + employee.getWage());
        System.out.println("Hours Worked: " + employee.getHours());
        System.out.println("Earnings: $" + employee.earnings());

        // toString() 메서드를 통한 정보 출력
        System.out.println("\nUsing toString() method:");
        System.out.println(employee.toString());
	}
	
	public static void useBaseEmployee() {
		BasePlusCommissionEmployee employee = new BasePlusCommissionEmployee("Jane", "Doe", "987-65-4321", 5000.0, 0.1, 1000.0);

        // 기본 급여 설정
        employee.setBaseSalary(1200.0);

        // 정보 출력
        System.out.println("Employee Information:");
        System.out.println("First Name: " + employee.getfirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("Social Security Number: " + employee.getSocialSecurityNumber());
        System.out.println("Gross Sales: $" + employee.getGrossSales());
        System.out.println("Commission Rate: " + employee.getCommissionRate());
        System.out.println("Base Salary: $" + employee.getBaseSalary());
        System.out.println("Earnings: $" + employee.earnings());

        // toString() 메서드를 통한 정보 출력
        System.out.println("\nUsing toString() method:");
        System.out.println(employee.toString());
	}
	
	public static void useSalaried() {
		SalariedEmployee employee = new SalariedEmployee("Alice", "Smith", "555-12-3456", 2000.0);

        // 주급 설정
        employee.setWeeklySalary(2500.0);

        // 정보 출력
        System.out.println("Employee Information:");
        System.out.println("First Name: " + employee.getfirstName());
        System.out.println("Last Name: " + employee.getLastName());
        System.out.println("Social Security Number: " + employee.getSocialSecurityNumber());
        System.out.println("Weekly Salary: $" + employee.getWeeklySalary());
        System.out.println("Earnings: $" + employee.earnings());

        // toString() 메서드를 통한 정보 출력
        System.out.println("\nUsing toString() method:");
        System.out.println(employee.toString());
    }
}
