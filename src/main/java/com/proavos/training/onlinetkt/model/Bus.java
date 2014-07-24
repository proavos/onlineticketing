package com.proavos.training.onlinetkt.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.proavos.training.onlinetkt.common.Constants;
import com.proavos.training.onlinetkt.common.Persistent;

@Entity
@Table(name = "TBL_BUS")
public class Bus extends Persistent {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "BUS_ID")
	private Long busId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "FROM_CITY_ID")
    private City fromCity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "TO_CITY_ID")
	private City toCity;

	@Column(name = "ROUTE_CODE")
	private String routeCode;

	@Column(name = "DEP_DATETIME")
	private Date departureDateTime;

	@Column(name = "ARR_DATETIME")
	private Date arrivalDateTime;

	@Column(name = "TICKET_PRICE")
	private BigDecimal ticketPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Constants.BusStatus status;

	public Long getBusId() {
		return busId;
	}

	public void setBusId(Long busId) {
		this.busId = busId;
	}

	public City getFromCity() {
		return fromCity;
	}

	public void setFromCity(City fromCity) {
		this.fromCity = fromCity;
	}

	public City getToCity() {
		return toCity;
	}

	public void setToCity(City toCity) {
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

	public BigDecimal getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(BigDecimal ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Constants.BusStatus getStatus() {
		return status;
	}

	public void setStatus(Constants.BusStatus status) {
		this.status = status;
	}
}
