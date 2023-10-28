package com.project.library.entities.enums;

public enum TrafficTicketStatus {

	WAITING_PAYMENT(1), PAID(2);

	private int code;

	private TrafficTicketStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public static TrafficTicketStatus valueOf(int code) {
		for (TrafficTicketStatus value : TrafficTicketStatus.values()) {
			if (value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid TrafficTicket Status Code");
	}
}
