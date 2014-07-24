package com.proavos.training.onlinetkt.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BusDTO implements Serializable {

	private Long busId;

	private String fromCity;

	private String toCity;

	private String routeCode;

	private Date departureDateTime;

	private Date arrivalDateTime;

	private BigDecimal perPassengerPrice;

	private Boolean available;// Whether or not bus is available to book

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getToCity() {
		return toCity;
	}

	public void setToCity(String toCity) {
		this.toCity = toCity;
	}

	public String getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	public Date getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public Date getArrivalDateTime() {
		return arrivalDateTime;
	}

	public void setArrivalDateTime(Date arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public BigDecimal getPerPassengerPrice() {
		return perPassengerPrice;
	}

	public void setPerPassengerPrice(BigDecimal perPassengerPrice) {
		this.perPassengerPrice = perPassengerPrice;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}
}
