package com.proavos.training.onlinetkt.model;

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
@Table(name = "TBL_CITY")
public class City extends Persistent {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "CITY_ID")
	private Long cityId;

    @Column(name = "CITY_NAME")
    private String cityName;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Constants.Status status;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public Constants.Status getStatus() {
		return status;
	}

	public void setStatus(Constants.Status status) {
		this.status = status;
	}
}
