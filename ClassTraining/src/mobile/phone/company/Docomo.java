package mobile.phone.company;

public class Docomo extends CarrierBase {
	
	private static final int BASIC_CHARGE = 1500;
	
	public Docomo() {
		this.carrierName = "Docomo";
		this.basicCharge = 1500;
		this.callCharge = 22;
	}
	
	//
	public void display() {
		content();
		
		if(this.basicCharge != BASIC_CHARGE) {
			System.out.println("☆コドモダケ割引(年齢が10歳未満は基本料無料)");
		}
		
		System.out.println("\n");
	}
	
	protected boolean check() {
		
		return Docomo.age < 10;
	}
	
	//
	public int calc() {
		this.isDiscount = check();
		
		if(this.isDiscount) {
			this.basicCharge = 0;
		}
		
		return this.basicCharge + this.callCharge * Docomo.time;
		
	}

}
