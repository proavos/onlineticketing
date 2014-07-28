package com.proavos.training.onlinetkt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SearchBusResponseDTO implements Serializable {

	private Integer noOfPassengers;

	private List<BusDTO> availableBusList = new ArrayList<>();

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public List<BusDTO> getAvailableBusList() {
		return availableBusList;
	}

	public void setAvailableBusList(List<BusDTO> availableBusList) {
		this.availableBusList = availableBusList;
	}

	public void addAvailableBus(BusDTO busDTO) {
		availableBusList.add(busDTO);
	}
}
