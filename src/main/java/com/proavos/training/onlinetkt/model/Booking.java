package com.proavos.training.onlinetkt.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.proavos.training.onlinetkt.common.Constants;
import com.proavos.training.onlinetkt.common.Persistent;

@Entity
@Table(name = "TBL_BOOKING")
public class Booking extends Persistent {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "BOOKING_ID")
	private Long bookingId;

    @Column(name = "BOOKING_REF")
    private String bookingReference;

	@Column(name = "BUS_ID")
	private Long busId;

	@Column(name = "SEATS_BOOKED")
	private Integer bookedSeats;

	@Column(name = "CONTACT_NAME")
	private String contactName;

	@Column(name = "CONTACT_PHONE")
	private String contactPhone;

	@Column(name = "TOTAL_PRICE")
	private BigDecimal totalPrice;

	@Column(name = "TOTAL_PAID")
	private BigDecimal totalPaid;

	@Column(name = "BOOKED_DATETIME")
	private Date bookedDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Constants.BookingStatus status;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getBookingReference() {
		return bookingReference;
	}

	public void setBookingReference(String bookingReference) {
		this.bookingReference = bookingReference;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public Integer getBookedSeats() {
		return bookedSeats;
	}

	public void setBookedSeats(Integer bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
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

	public BigDecimal getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(BigDecimal totalPaid) {
		this.totalPaid = totalPaid;
	}

	public Date getBookedDateTime() {
		return bookedDateTime;
	}

	public void setBookedDateTime(Date bookedDateTime) {
		this.bookedDateTime = bookedDateTime;
	}

	public Constants.BookingStatus getStatus() {
		return status;
	}

	public void setStatus(Constants.BookingStatus status) {
		this.status = status;
	}
}
