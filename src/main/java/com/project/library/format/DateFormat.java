package com.project.library.format;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormat {

	public LocalDate formatToDate(String data) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataHoraConvertida = LocalDate.parse(data, dateFormatter);
		return dataHoraConvertida;
	}
	
	public LocalDate formatDate(LocalDate data) {
		String dateformated;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		dateformated = dateFormatter.format(data);
		LocalDate dataHoraConvertida = LocalDate.parse(dateformated, dateFormatter);
		return dataHoraConvertida;
	}
	
	public LocalDateTime formatToDateTime(LocalDateTime data) {
		String dateformated;
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm");
		dateformated = dateFormatter.format(data);
		LocalDateTime dataHoraConvertida = LocalDateTime.parse(dateformated, dateFormatter);
		return dataHoraConvertida;
	}
}
