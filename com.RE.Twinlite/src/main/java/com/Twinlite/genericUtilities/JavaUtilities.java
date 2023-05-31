package com.Twinlite.genericUtilities;

import java.util.Date;
import java.util.Random;
/**
 * this class is used to get random numbers and system date
 * @author satya
 *
 */
public class JavaUtilities {
	/**
	 * this method is used to return 3 digits random numbers
	 * @return
	 */
	public int getRandomNumber() {
		Random ran=new Random();
		int ranNo = ran.nextInt(900)+100;
		return ranNo;
	}
	/**
	 * this method is used to return the sysytem date
	 * @return
	 */
	public String currentSystemDate() {
		Date date=new Date();
		String cdate=date.toString();
		String d[]=cdate.split(" ");
		
		int month=date.getMonth();
		String week=d[0];
		String tdate=d[2];
		String year=d[5];
		String dateFormat=month+" "+week+" "+tdate+" "+year;
		return dateFormat;
	}
	

}
