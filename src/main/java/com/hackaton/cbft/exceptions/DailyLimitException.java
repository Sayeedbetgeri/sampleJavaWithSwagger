package com.hackaton.cbft.exceptions;

import com.hackaton.cbft.Constants.Constants;

public class DailyLimitException extends RuntimeException {
	
	public DailyLimitException() {
		super("Daily Transaction Limit is : "+ Constants.DAILY_LIMIT);
	}

}
