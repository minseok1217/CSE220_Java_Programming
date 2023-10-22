package Assignment.Lab05;

public class ResizableCircle extends Circle implements Resizable{
    public ResizableCircle(double radius){
        super(radius);
    }

    public void resize(int p){
        double p1 = (double)p;
        this.setRadius(this.getRadius() * (p1 / 100));
    }
}
