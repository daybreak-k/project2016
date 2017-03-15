package mobile.phone.company;

import java.util.Scanner;

public class PhoneCalcMain {

	public static void main(String[] args) {
		/*
		final CalcTalkFee calcTalkFee = new CalcTalkFee();
		calcTalkFee.exec();
		*/
		
		int min = 99999;
		int docomoCalc = 0;
		int auCalc = 0;
		int softbankCalc = 0;
		
		Docomo docomo = new Docomo();
		Au au = new Au();
		Softbank softbank = new Softbank();
		
		String recommend;
		
		CarrierBase.input();
		
		docomoCalc = docomo.calc();
		softbankCalc = softbank.calc();
		auCalc = au.calc();
		
		docomo.display();
		softbank.display();
		au.display();
		
		if(min > docomoCalc) {
			min = docomoCalc;
		}
		if(min > auCalc) {
			min = auCalc;
		}
		if(min > softbankCalc) {
			min = softbankCalc;
		}
		
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
