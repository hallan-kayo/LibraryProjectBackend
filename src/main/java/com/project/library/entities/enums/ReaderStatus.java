package com.project.library.entities.enums;

public enum ReaderStatus {

	RELEASED(1),
	BLOCKED(2);
	
	private int code;
	
	private ReaderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return this.code;
	}
	
	public static ReaderStatus valueOf(int code) {
		for(ReaderStatus value: ReaderStatus.values()) {
			if(value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid Reader Status Code");
	}
}
