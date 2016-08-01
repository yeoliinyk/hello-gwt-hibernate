package com.yevgenoliinykov.HelloGWTHibernate.client.util;

import java.util.Date;

import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.TimeZone;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.AppConstants;
import com.yevgenoliinykov.HelloGWTHibernate.client.resources.messages.Messages;
import com.yevgenoliinykov.HelloGWTHibernate.shared.LogInInfo;

/**
 * This class holds global LogInInfo object that contains information about
 * logged in user. Also provides methods for greeting user after successful log
 * in.
 *
 * @author Yevgen Oliinykov
 *
 */
public class AppUtil {

    // Holds information about logged in user.
    private LogInInfo appLogInInfo;

    public AppUtil() {
    }

    /**
     * Returns current time in hours on client machine.
     *
     * @return current time in hours.
     */
    @SuppressWarnings("deprecation")
    public static byte getCurrentTime() {
	Date date = new Date();
	DateTimeFormat dtf = DateTimeFormat.getFormat("HH");
	return Byte.valueOf(dtf.format(date, TimeZone.createTimeZone(date.getTimezoneOffset())));
    }

    /**
     *
     * Returns localizable greeting message depends on current time in hours and
     * browser locale.
     *
     * @param hour
     *            hour in 24 format.
     * @param messages
     *            localizable interface that extends gwt Constants interface.
     * @return localizable message.
     */
    public static String getGreetingMessage(byte hour, Messages messages) {
	String result = "";
	if (hour < 0 || hour > 24) {
	    throw new IllegalArgumentException("The time is out of Earth time range");
	}
	if (hour >= AppConstants.MORNING_START_HOUR && hour < AppConstants.DAY_START_HOUR) {
	    result = messages.goodMorning();
	} else if (hour >= AppConstants.DAY_START_HOUR && hour < AppConstants.EVENING_START_HOUR) {
	    result = messages.goodDay();
	} else if (hour >= AppConstants.EVENING_START_HOUR && hour < AppConstants.NIGHT_START_HOUR) {
	    result = messages.goodEvening();
	} else if (hour >= AppConstants.NIGHT_START_HOUR || hour < AppConstants.DAY_START_HOUR) {
	    result = messages.goodNight();
	}
	return result;
    }

    public LogInInfo getAppLogInInfo() {
	return appLogInInfo;
    }

    public void setAppLogInInfo(LogInInfo appLogInInfo) {
	this.appLogInInfo = appLogInInfo;
    }

}
