package mobile.phone.company;

public class Softbank extends CarrierBase {

	private static final int BASIC_CHARGE = 980;
	
	public Softbank() {
		this.carrierName = "Softbank";
		this.basicCharge = 980;
		this.callCharge = 36;
	}
	
	public void display() {
		System.out.println("携帯会社 : " + carrierName);
		System.out.println("基本料金 : " + this.basicCharge);
		System.out.println("通話料(分) : " + this.callCharge);
		System.out.println("一ヶ月の使用料金 : " + this.monthlyCharge);
		
		if(this.basicCharge != BASIC_CHARGE) {
			System.out.println("☆通話時間が3時間以上なら基本料金が2000円となり、3時間を肥えた分の通話料はかからない");
		}
		
		System.out.println("\n");
	}
	
	private boolean check(int time) {
		if(time >= 180) {
			return true;
		}
		
		return false;
	}
	
	public int calc() {
		this.isDiscount = check(this.time);
		
		if(this.isDiscount) {
			this.time = 180;
			this.basicCharge = 2000;
		}
		
		this.monthlyCharge = this.basicCharge + this.callCharge * this.time;
		
		return this.monthlyCharge;
	}
}
