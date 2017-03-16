package mobile.phone.company;

import java.util.Scanner;

public abstract class CarrierBase {
	
	protected int basicCharge;
	protected int callCharge;
	protected String carrierName;
	protected boolean isDiscount;
	
	protected static String name;
	protected static int age = 0;
	protected static String job;
	protected static int time = 0;
	
	public static String getName() {
		return name;
	}
	
	public String getCariier() {
		return this.carrierName;
	}
	
	public static void input() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("名前の入力");
		name = scanner.next();
		System.out.println("年齢の入力");
		age = scanner.nextInt();
		System.out.println("職業の入力");
		job = scanner.next();
		System.out.println("一ヶ月の通話時間の入力");
		time = scanner.nextInt();
		
		scanner.close();
	}
	
	protected void content() {
		System.out.println("携帯会社 : " + carrierName);
		System.out.println("基本料金 : " + this.basicCharge);
		System.out.println("通話料(分) : " + this.callCharge);
		System.out.println("一ヶ月の使用料金 : " + calc());
	}
	
	public abstract void display();
	
	public abstract int calc();
	
	protected abstract boolean check();
	

}
