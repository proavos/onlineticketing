package com.proavos.training.onlinetkt.dto;

import java.io.Serializable;
import java.util.Date;

public class SearchBusRequestDTO implements Serializable {

	private Long fromCityId;

	private Long toCityId;

	private Date departureFromDate;

	private Date departureToDate;

	private String departureDateStr;

	private Integer noOfPassengers;

	public Long getFromCityId() {
		return fromCityId;
	}

	public void setFromCityId(Long fromCityId) {
		this.fromCityId = fromCityId;
	}

	public Long getToCityId() {
		return toCityId;
	}

	public void setToCityId(Long toCityId) {
		this.toCityId = toCityId;
	}

	public Date getDepartureFromDate() {
		return departureFromDate;
	}

	public Date getDepartureToDate() {
		return departureToDate;
	}

	public void setDepartureToDate(Date departureToDate) {
		this.departureToDate = departureToDate;
	}

	public String getDepartureDateStr() {
		return departureDateStr;
	}

	public void setDepartureDateStr(String departureDateStr) {
		this.departureDateStr = departureDateStr;
	}

	public void setDepartureFromDate(Date departureFromDate) {
		this.departureFromDate = departureFromDate;
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
}
