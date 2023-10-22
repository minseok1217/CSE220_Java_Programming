package java_lab4;

public class CommissionEmployee extends Employee{
	private double grossSales;
	private double commisionRate;
	
	public CommissionEmployee(String first,String last, String social, double gross,double rate) {
		super(first,last,social);
		this.grossSales=gross;
		this.commisionRate=rate;
	}
	
	public void setGrossSales(double gross) {
		this.grossSales=gross;
	}
	
	public double getGrossSales() {
		return this.grossSales;
	}
	
	public void setCommissionRate(double rate) {
		this.commisionRate=rate;
	}
	
	public double getCommissionRate() {
		return this.commisionRate;
	}
	
	public double earnings() {
		return this.grossSales*(1-this.commisionRate);
	}
	
	public String toString() {
        return "CommissionEmployee: " + this.getfirstName() + " " + this.getLastName() + " "+ "Eamings(): " + earnings();
    }
}
