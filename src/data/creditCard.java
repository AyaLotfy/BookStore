package data;

import java.sql.Date;

public class creditCard {

	String number;

	Date expireDate;

	public creditCard(String number, Date date) {
		this.number = number;
		this.expireDate = date;
	}
}
