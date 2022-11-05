package poly.app;

import poly.Banner;

public class FunBanner implements Banner {

	@Override
	public void print() {
		System.out.println("┌────────────────────────┐");
		System.out.println("│       score print      │");
		System.out.println("└────────────────────────┘");	
		
	}

}
