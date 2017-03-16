package mobile.phone.company;

public class Softbank extends CarrierBase {

	private static final int BASIC_CHARGE = 980;
	
	public Softbank() {
		this.carrierName = "Softbank";
		this.basicCharge = 980;
		this.callCharge = 36;
	}
	
	public void display() {
		
		content();
		
		if(this.basicCharge != BASIC_CHARGE) {
			System.out.println("☆通話時間が3時間以上なら基本料金が2000円となり、3時間を超えた分の通話料はかからない");
		}
		
		System.out.println("\n");
	}
	
	protected boolean check() {
		
		return Softbank.time >= 180;
		
	}
	
	public int calc() {
		int tmpTime = Softbank.time;
		
		this.isDiscount = check();
		
		if(this.isDiscount) {
			tmpTime = 180;
			this.basicCharge = 2000;
		}
		
		return this.basicCharge + this.callCharge * tmpTime;
	}
}
