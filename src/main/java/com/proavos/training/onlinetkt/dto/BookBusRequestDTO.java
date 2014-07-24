package com.proavos.training.onlinetkt.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class BookBusRequestDTO implements Serializable {

	private Long busId;

	private Integer noOfPassengers;

	private String contactPerson;

	private String contactPhone;

	private BigDecimal totalPrice;

	private Boolean payNow; // whether to pay now or pay later

	private CardPaymentDetailsDTO cardPaymentDetails;

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Boolean getPayNow() {
		return payNow;
	}

	public void setPayNow(Boolean payNow) {
		this.payNow = payNow;
	}

	public CardPaymentDetailsDTO getCardPaymentDetails() {
		return cardPaymentDetails;
	}

	public void setCardPaymentDetails(CardPaymentDetailsDTO cardPaymentDetails) {
		this.cardPaymentDetails = cardPaymentDetails;
	}
}
