package com.proavos.training.onlinetkt.dto;

import java.io.Serializable;
import java.util.Date;

public class SearchBusRequestDTO implements Serializable {

	private Long fromCityId;

	private Long toCityId;

	private Date depatureDate;

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

	public Date getDepatureDate() {
		return depatureDate;
	}

	public void setDepatureDate(Date depatureDate) {
		this.depatureDate = depatureDate;
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}
}
