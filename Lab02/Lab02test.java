package Java_Assignment.Lab02

public class Lab02test {
   public static void main(String[] args) {
		useTime();
		// useRational();
		// useCraps();
   }
   
   public static void useRational() {
      Rational r1=new Rational(5,7);
      Rational r2=new Rational(1,3);
      Rational r3 = r1.add(r2);
      System.out.println(r1);
      System.out.println(r2);
	  System.out.println(r3);
   }
   
   public static void useCraps() {
      Craps c1 = new Craps();
      c1.play();
   }
   
   public static void useTime() {
      Time t1=new Time();
      Time t2=new Time(4);
      Time t3=new Time(5,8);
      Time t4=new Time(7,8,45);
      Time t5=new Time(t4);
      Time t6=new Time(new Time(6,5,9));
      System.out.println(t5);
      System.out.println(t4);
   }
}
