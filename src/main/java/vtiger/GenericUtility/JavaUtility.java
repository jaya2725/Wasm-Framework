package vtiger.GenericUtility;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random r= new Random();
		int ran = r.nextInt(1000);
		return ran;
	}
	public String  getSystemData() {
		Date date=new Date();
		String d = date.toString();
		return d;
		
	}
	
	public String getSystemDateInFormat() {
		Date d =new	Date();
	   String[]	dArr=d.toString().split(" ");
	   String date=dArr[2];
	   String Month=dArr[1];
	   String Year=dArr[5];
	   String Time=dArr[3].replace(":","_");
	   String CurrentDateAndTime=date+" "+Month+" "+Year+" "+Time;
	   return CurrentDateAndTime;
		


}
}