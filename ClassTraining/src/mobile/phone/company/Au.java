package mobile.phone.company;

public class Au extends CarrierBase {
	
	private static final int BASIC_CHARGE = 1300;

	public Au() {
		this.carrierName = "Au";
		this.basicCharge = 1300;
		this.callCharge = 25;
	}
	
	public void display() {
		System.out.println("携帯会社 : " + carrierName);
		System.out.println("基本料金 : " + this.basicCharge);
		System.out.println("通話料(分) : " + this.callCharge);
		System.out.println("一ヶ月の使用料金 : " + this.monthlyCharge);
		
		if(this.basicCharge != BASIC_CHARGE) {
			System.out.println("☆学生割引(学生は基本料-500円)");
		}
		
		System.out.println("\n");
	}
	
	private boolean check(String job) {
		if(job.matches(".*学生") || job.equals("高校生")) {
			return true;
		}
		
		return false;
	}
	
	public int calc() {
		this.isDiscount = check(this.job);
		
		if(this.isDiscount) {
			this.basicCharge = this.basicCharge - 500;
		}
		
		this.monthlyCharge = this.basicCharge + this.callCharge * this.time;
		
		return this.monthlyCharge;
	}
}
