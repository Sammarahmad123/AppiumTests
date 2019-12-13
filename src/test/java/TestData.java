

import java.util.Random;

public  class TestData {

	public static class testData
	{
		
		public static String ToolkitName="IOS Test ToolKit "+generateRandomToolKitName();
		public static int TrainingCode=generateRandomTrainingCOde();
		public static String TrainingName="This is a test training title "+ generateRandomTrainingTitle();
		public static int OrganID=870799;
		public static int UserID=20802;
		public static String UserName="Automated user";
		
		
		public static String generateRandomToolKitName()
		{
			String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 7) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        return saltStr;
		}
		
		
		public static int generateRandomTrainingCOde()
		{
			String SALTCHARS = "1234567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 5) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        int  saltStr = Integer.parseInt(salt.toString());
	        return saltStr;
		}
		
		public static String generateRandomTrainingTitle()
		{
			String SALTCHARS = "A BC   D E   F G H   I JK LMN O PQRSTUVWXYZ  1  2  3  4567890";
	        StringBuilder salt = new StringBuilder();
	        Random rnd = new Random();
	        while (salt.length() < 30) { // length of the random string.
	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
	            salt.append(SALTCHARS.charAt(index));
	        }
	        String saltStr = salt.toString();
	        return saltStr;
		}
		
		
	}
}
