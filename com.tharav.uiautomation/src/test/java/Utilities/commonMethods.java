package Utilities;

import java.util.Properties;
import java.util.Random;

import com.Tharav.constants.constants;

public class commonMethods {
	
	
	
	public  void loadProperties() 
	{				
		Properties properties = new Properties();
			try {
				//properties.load(getClass().getResourceAsStream("./src/test/resources/utilsres/config.properties"));
				properties.load(getClass().getResourceAsStream("/utils/config.properties"));
			}
			catch( Exception e)
			{
				e.printStackTrace();
			}
		 constants.C_APP_URL= properties.getProperty("APP_URL");
		 constants.C_BROWSER =properties.getProperty("BROWSER");
		 constants.C_EMAIL=properties.getProperty("USERNAME");
		 constants.C_PASSWORD =properties.getProperty("PASSWORD");
		 System.out.println(constants.C_BROWSER);
				 
	}
	public static String randomString(int len)
	{
		//String randomString= null;
		String alphabet = "ABCDEFGHIGKLMNOPQRSTUVWXYZ";
		//Create a random string builder
		StringBuilder sb = new StringBuilder();
		//create a object of random class
		Random random = new Random();
		//specify the length of random string
		//int length = 7;
		for(int i = 0; i <=len; i ++)
		{
			//generate random index no
			int index = random.nextInt(alphabet.length());
			//get character specifed by index from the string
			char randomchar = alphabet.charAt(index);
			sb.append(randomchar);
		}
		try {
		constants.RANDOMSTRING = sb.toString();
		constants.RANDOMSTRING = constants.RANDOMSTRING.toLowerCase();
		System.out.println("Random string " + constants.RANDOMSTRING);
		}
		catch(Exception  e)
		{
			e.printStackTrace();
		}
		//System.out.println("Random string " + randomString.toLowerCase());
		 return constants.RANDOMSTRING;
	}
   
}
