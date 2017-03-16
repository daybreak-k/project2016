package mobile.phone.company;

import java.util.ArrayList;
import java.util.List;

public class PhoneCalcMain {

	public static void main(String[] args) {
		
		CarrierBase.input();
		
		final List<CarrierBase> list = new ArrayList<CarrierBase>();
		list.add(new Softbank());
		list.add(new Docomo());
		list.add(new Au());
		
		int min = Integer.MAX_VALUE;
		String recommend = null;
		for (final CarrierBase carrier : list) {
			int calcResult = carrier.calc();
			carrier.display();
			
			if(min > calcResult) {
				min = calcResult;
				recommend = carrier.getCariier();
				continue;
			}
		}
		
		System.out.println(CarrierBase.getName() + "さんにお勧めの携帯会社名 : " + recommend);
		
	}
}
