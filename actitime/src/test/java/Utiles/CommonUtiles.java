package Utiles;

import java.util.Date;

public class CommonUtiles {
	
	public static String getEmailTimeStamp()
	{
		Date date = new Date();
		String timestamp = date.toString().replace(" ","_").replace(":","_")+"@gmail.com";
		return timestamp;
	}
}
