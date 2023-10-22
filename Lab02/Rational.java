
public class Rational {
   private int numerator;
   private int denominator;
   
   public void fpRepresentation() {
      System.out.printf("Rational number = %.2f",numerator/denominator);
   }
   
   public String toString() {
      return String.format("%d / %d ", numerator,denominator);
   }
   
   public Rational() {}
   public Rational(int a, int b) {
      numerator=a;
      denominator=b;
      reduce();

   }
   
   
   public int get_denominator() {
      return this.denominator;
   }
   public int get_numerator() {
      return this.numerator;
   }
	public void set_denominator(int num) {
		this.denominator=num;
   }
   
	public Rational add(Rational other) {
		int tmp1 = this.numerator * other.get_denominator();
		int tmp2 = this.denominator * other.get_denominator();
		int tmp3 = other.get_numerator() * this.denominator;
		Rational tmp = new Rational(tmp1 + tmp3, tmp2);
		tmp.reduce();
		return tmp;
	}

   public Rational sub(Rational other) {

		int tmp1 = this.numerator * other.get_denominator();
		int tmp2 = this.denominator * other.get_denominator();
		int tmp3 = other.get_numerator() * this.denominator;
		
		if (tmp1 > tmp3){
			Rational tmp = new Rational(tmp1 - tmp3, tmp2);
			tmp.reduce();
			return tmp; 
		}
		else{
			Rational tmp = new Rational(tmp3 - tmp1, tmp2);
			tmp.reduce();
			return tmp;
		}
		
   }
   public Rational multiply(Rational other) {
		Rational tmp = new Rational(this.numerator * other.get_numerator(), this.denominator * other.get_denominator());
		tmp.reduce();

		return tmp;
   }
   public Rational divde(Rational other) {
      Rational tmp = new Rational(this.numerator * other.get_denominator(), this.denominator * other.get_numerator());
		tmp.reduce();

		return tmp;
   }
   
   
   private void reduce() {
    	// private int numerator;
		// private int denominator;
		int a = 0;
		if(this.numerator > this.denominator){
			a=this.numerator;
		}
		else{
			a = this.denominator;
		}
		for(int i = 2; i <= a ; i++){
			if( numerator / i ==0 && denominator / i ==0){
				while (this.numerator % i == 0 && this.denominator % i == 0){
					this.denominator = this.denominator / i;
					this.numerator = this.numerator / i;
				}

			}
		}		
	}   
}