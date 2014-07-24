package com.proavos.training.onlinetkt.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class CardPaymentDetailsDTO implements Serializable {

	private String cardHolderName;

	private String cardNumber;

	private String expiryMMYYYY;

	private String cvv;

	private BigDecimal totalAmountPaid;

	public String getCardHolderName() {
		return cardHolderName;
	}

	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryMMYYYY() {
		return expiryMMYYYY;
	}

	public void setExpiryMMYYYY(String expiryMMYYYY) {
		this.expiryMMYYYY = expiryMMYYYY;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public BigDecimal getTotalAmountPaid() {
		return totalAmountPaid;
	}

	public void setTotalAmountPaid(BigDecimal totalAmountPaid) {
		this.totalAmountPaid = totalAmountPaid;
	}
}
