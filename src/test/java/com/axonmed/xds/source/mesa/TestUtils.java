/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/

package com.axonmed.xds.source.mesa;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @author <a href="mailto:seknoop@us.ibm.com">Sarah Knoop</a>
 *
 */
public class TestUtils {
	
	/*Forms a time stamp for logging of the form YYYY/MM/DD hh:mm:ss using current system time*/
	public static String formTimestamp(){
		long time = System.currentTimeMillis();
		GregorianCalendar c = new GregorianCalendar();
		c.setTimeInMillis(time);
		StringBuffer timeStamp = new StringBuffer();
		timeStamp.append(c.get(GregorianCalendar.YEAR));
		timeStamp.append("/");
		timeStamp.append(c.get(GregorianCalendar.MONTH) + 1);
		timeStamp.append("/");
		timeStamp.append( c.get(GregorianCalendar.DAY_OF_MONTH));
		timeStamp.append(" ");
		timeStamp.append( c.get(GregorianCalendar.HOUR_OF_DAY));
		timeStamp.append(":");
		timeStamp.append(c.get(GregorianCalendar.MINUTE));
		timeStamp.append(":");
		timeStamp.append(c.get(GregorianCalendar.SECOND));
		return timeStamp.toString();
	}
	
	/**
	 * Forms a HL7 v2.5 DTM time stamp for logging of the form YYYYMMDDHHMMSS
	 *  using current system time*/
	public static String formDTM(){
		SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmss");
		
		// SEK - this code is not working correctly - see Bugzilla bug - 226107.
/*		GregorianCalendar c = new GregorianCalendar();
		c.setTimeInMillis(time);
		StringBuffer timeStamp = new StringBuffer();
		timeStamp.append(c.get(GregorianCalendar.YEAR));
		timeStamp.append(c.get(GregorianCalendar.MONTH) + 1);
		timeStamp.append( c.get(GregorianCalendar.DAY_OF_MONTH));
		timeStamp.append( c.get(GregorianCalendar.HOUR_OF_DAY));
		timeStamp.append(c.get(GregorianCalendar.MINUTE));
		timeStamp.append(c.get(GregorianCalendar.SECOND));*/
		
		return date.format(new Date());
	}
	
	/**
	 * Forms a HL7 v2.5 DTM time stamp for logging of the form YYYYMMDDHHMMSS
	 *  using current system time in GMT time zone */
	public static String formGMT_DTM(){
		String timeInGMT = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		// first, set up time in current time zone (where program is running
		sdf.setTimeZone(TimeZone.getDefault());
		String tm = sdf.format(new Date());
		
		// convert (though there is probably is some circular logic here, oh well
		Date specifiedTime;
		//System.out.println("Specified time is: " + tm);
		//System.out.println("time zone is:GMT" + offset);
		try {
			// switch timezone
			specifiedTime = sdf.parse(tm);
			sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
			timeInGMT = sdf.format(specifiedTime);
			//System.out.println("Specified time post conversion: "+ tm);
			//System.exit(0);
		} catch (ParseException e) {
			// FIXME just skip the conversion, bad time stamp, hence bad
			// CDA!
			// Maybe this should be more robust?? An Exception?
		}
		return timeInGMT;
	}
}
