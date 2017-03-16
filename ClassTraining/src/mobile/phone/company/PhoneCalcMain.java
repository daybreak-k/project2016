package mobile.phone.company;

public class PhoneCalcMain {

	public static void main(String[] args) {
		
		CarrierBase.input();
		
		int docomoCalc = 0;
		Docomo docomo = new Docomo();
		docomoCalc = docomo.calc();
		docomo.display();
		
		int auCalc = 0;
		Au au = new Au();
		auCalc = au.calc();
		au.display();

		int softbankCalc = 0;
		Softbank softbank = new Softbank();
		softbankCalc = softbank.calc();
		softbank.display();
		
		int min = Integer.MAX_VALUE;
		if(min > docomoCalc) {
			min = docomoCalc;
		}
		if(min > auCalc) {
			min = auCalc;
		}
		if(min > softbankCalc) {
			min = softbankCalc;
		}
		
		String recommend;
		if(min == docomoCalc) {
			recommend = docomo.getCariier();
		} else if(min == auCalc) {
			recommend = au.getCariier();
		} else {
			recommend = softbank.getCariier();
		}
		
		System.out.println(CarrierBase.getName() + "さんにお勧めの携帯会社名 : " + recommend);
		
	}
}
