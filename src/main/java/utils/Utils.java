package utils;

public class Utils {
	public static void waitTill(int seconds)
	{
		try {
			Thread.sleep(seconds);
		}
		catch (InterruptedException e) {
			
		}
	}
	
	
}
