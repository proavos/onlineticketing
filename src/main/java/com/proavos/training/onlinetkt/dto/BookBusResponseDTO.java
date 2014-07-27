package com.proavos.training.onlinetkt.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.proavos.training.onlinetkt.common.Constants;

public class BookBusResponseDTO implements Serializable {

	private BusDTO busDetails;

	private Long bookId;

	private String bookingReference;

	private Date bookedDateTime;

	private Constants.BookingStatus bookingStatus;

	private Integer noOfPassengers;

	private BigDecimal totalPrice;

	private BigDecimal totalPaid;

	private String contactPerson;

	private String contactPhone;

	private Long version;

	public BusDTO getBusDetails() {
		return busDetails;
	}

	public void setBusDetails(BusDTO busDetails) {
		this.busDetails = busDetails;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookingReference() {
		return bookingReference;
	}

	public void setBookingReference(String bookingReference) {
		this.bookingReference = bookingReference;
	}

	public Date getBookedDateTime() {
		return bookedDateTime;
	}

	public void setBookedDateTime(Date bookedDateTime) {
		this.bookedDateTime = bookedDateTime;
	}

	public Constants.BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(Constants.BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public BigDecimal getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(BigDecimal totalPaid) {
		this.totalPaid = totalPaid;
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

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public String toString(){
		StringBuilder state = new StringBuilder();
		state.append("bookingId=").append(getBookId());
		state.append("|busId=").append(getBusDetails().getBusId());
		state.append("|fromCity=").append(getBusDetails().getFromCity());
		state.append("|toCity=").append(getBusDetails().getToCity());
		state.append("|depDateTime=").append(getBusDetails().getDepartureDateTime());
		state.append("|bookingRef=").append(getBookingReference());
		state.append("|totalPax=").append(getNoOfPassengers());
		state.append("|totalPrice=").append(getTotalPrice());
		state.append("|totalPaid=").append(totalPaid);
		state.append("|status=").append(getBookingStatus());
		state.append("|contactName=").append(getContactPerson());
		state.append("|contactPhone=").append(getContactPhone());
		state.append("|bookedTimestamp=").append(getBookedDateTime());

		return state.toString();
	}
}
