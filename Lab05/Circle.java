package Assignment.Lab05;

public class Circle implements GeometricObject{
    private double radius;
    
    public Circle(){
        this.radius = 1.0;
    }
    public Circle(double radius){
        this.radius = radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius = radius;
    }
    public String toString(){
        return "Circle{" + "radius = " + radius + "}";
    }
    public double getPerimeter(){
        return 2 * Math.PI * this.getRadius();
    }
    public double getArea(){
        return Math.PI * this.getRadius() * this.getRadius();
    }
}
