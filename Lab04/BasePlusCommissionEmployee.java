package java_lab4;

public class BasePlusCommissionEmployee extends CommissionEmployee{
	private double baseSalary;
	
	public BasePlusCommissionEmployee(String first,String last,String social, double gross,double rate,double base) {
		super(first,last,social,gross,rate);
		this.baseSalary=base;
	}
	
	public void setBaseSalary(double base) {
		this.baseSalary=base;
	}
	
	public double getBaseSalary() {
		return this.baseSalary;
	}
	
	public double earnings() {
		return this.baseSalary;
	}
	
	public String toString() {
        return "BasePlusCommissionEmployee: " + this.getfirstName() + " " + this.getLastName() +" "+ "Eamings(): " + earnings();
    }
}
