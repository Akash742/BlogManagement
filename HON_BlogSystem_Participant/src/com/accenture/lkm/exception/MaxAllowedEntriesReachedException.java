package com.accenture.lkm.exception;

public class MaxAllowedEntriesReachedException extends Exception {
	public MaxAllowedEntriesReachedException() {		
		super("User cannot enter more than 5 Blog entries");
	}
}
