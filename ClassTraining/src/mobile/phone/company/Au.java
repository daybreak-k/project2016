package mobile.phone.company;

public class Au extends CarrierBase {
	
	private static final int BASIC_CHARGE = 1300;

	public Au() {
		this.carrierName = "Au";
		this.basicCharge = 1300;
		this.callCharge = 25;
	}
	
	public void display() {
		content();
		
		if(this.basicCharge != BASIC_CHARGE) {
			System.out.println("☆学生割引(学生は基本料-500円)");
		}
		
		System.out.println("\n");
	}
	
	public boolean check() {
		
		return (this.job.matches(".*学生") || this.job.equals("高校生"));
	}
	
	public int calc() {
		this.isDiscount = check();
		
		if(this.isDiscount) {
			this.basicCharge = this.basicCharge - 500;
		}
		
		return this.basicCharge + this.callCharge * this.time;
	}
}
