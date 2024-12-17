package genericUtilities;

import java.util.Random;

public class Java_Utility {
	
	/**
	 * This Method is used to avoid dublicate values
	 * @author Debanjan
	 * @return
	 * */
	
	public int getRandomNum() {
		
		Random ran = new Random();
		int value = ran.nextInt(1000);
		return value;
		
		
	}

}
