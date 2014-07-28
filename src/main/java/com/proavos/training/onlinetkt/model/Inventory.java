package com.proavos.training.onlinetkt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_INVENTORY")
public class Inventory {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "INVENTORY_ID")
	private Long cityId;

    @Column(name = "BUS_ID")
    private Long busId;

	@Column(name = "SEATS_CAPACITY")
	private Integer seatsCapacity;

	@Column(name = "SEATS_BOOKED")
	private Integer seatsBooked;

	@Column(name = "SEATS_AVAILABLE")
	private Integer seatsAvailable;

	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public Integer getSeatsCapacity() {
		return seatsCapacity;
	}

	public void setSeatsCapacity(Integer seatsCapacity) {
		this.seatsCapacity = seatsCapacity;
	}

	public Integer getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked = seatsBooked;
	}

	public Integer getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(Integer seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}
}
