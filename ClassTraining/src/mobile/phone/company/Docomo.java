package mobile.phone.company;

public class Docomo extends CarrierBase {
	
	private static final int BASIC_CHARGE = 1500;
	
	public Docomo() {
		this.carrierName = "Docomo";
		this.basicCharge = 1500;
		this.callCharge = 22;
	}
	
	public void display() {
		System.out.println("携帯会社 : " + carrierName);
		System.out.println("基本料金 : " + this.basicCharge);
		System.out.println("通話料(分) : " + this.callCharge);
		System.out.println("一ヶ月の使用料金 : " + this.monthlyCharge);
		
		if(this.basicCharge != BASIC_CHARGE) {
			System.out.println("☆コドモダケ割引(年齢が10歳未満は基本料無料)");
		}
		
		System.out.println("\n");
	}
	
	private boolean check() {
		if(this.age < 10) {
			return true;
		}
		
		return false;
	}
	
	public int calc() {
		this.isDiscount = check();
		
		if(this.isDiscount) {
			this.basicCharge = 0;
		}
		
		this.monthlyCharge = this.basicCharge + this.callCharge * this.time;
		
		return this.monthlyCharge;
		
	}

}
