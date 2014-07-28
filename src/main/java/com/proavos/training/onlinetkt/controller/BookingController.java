package com.proavos.training.onlinetkt.controller;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.ejb.EJB;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.proavos.training.onlinetkt.common.ApplicationException;
import com.proavos.training.onlinetkt.dto.BookBusRequestDTO;
import com.proavos.training.onlinetkt.dto.BookBusResponseDTO;
import com.proavos.training.onlinetkt.dto.SearchBusRequestDTO;
import com.proavos.training.onlinetkt.dto.SearchBusResponseDTO;
import com.proavos.training.onlinetkt.service.SearchAndBookService;

@Controller
@RequestMapping({"/booking"})
public class BookingController {

	private static final String SEARCH_VIEW = "searchResult";

	private static final String BOOKING_VIEW = "booking";


	@EJB
	private SearchAndBookService searchAndBookService;

	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public ModelAndView loadBookingPage(@RequestParam Integer busId,
	                                    @RequestParam BigDecimal price,
	                                    @RequestParam Integer noOfPax) {
		ModelAndView bookingModelAndView = new ModelAndView(BOOKING_VIEW);
		bookingModelAndView.addObject("busId", busId);
		bookingModelAndView.addObject("noOfPax", noOfPax);
		bookingModelAndView.addObject("price", price);
		return bookingModelAndView;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView searchBus(@RequestParam Long fromCityId,
	                              @RequestParam Long toCityId,
	                              @RequestParam String departureDateStr,
	                              @RequestParam Integer noOfPassengers) {

		ModelAndView searchModelAndView = new ModelAndView(SEARCH_VIEW);

		try {
			Date fromDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(
				departureDateStr + " 00:00:00");
			Date toDate = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH).parse(
				departureDateStr + " 23:59:59");


			SearchBusRequestDTO searchBusRequestDTO = new SearchBusRequestDTO();
			searchBusRequestDTO.setFromCityId(fromCityId);
			searchBusRequestDTO.setToCityId(toCityId);
			searchBusRequestDTO.setNoOfPassengers(noOfPassengers);
			searchBusRequestDTO.setDepartureFromDate(fromDate);
			searchBusRequestDTO.setDepartureToDate(toDate);
			SearchBusResponseDTO searchBusResponseDTO = searchAndBookService.searchBusAvailability(searchBusRequestDTO);
			searchBusResponseDTO.setNoOfPassengers(noOfPassengers);
			searchModelAndView.addObject("result", searchBusResponseDTO);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return searchModelAndView;
	}

	@RequestMapping(value = "/book", method = RequestMethod.POST)
	@ResponseBody
	public BookBusResponseDTO bookBus(@RequestBody BookBusRequestDTO bookBusRequestDTO) {
		BookBusResponseDTO bookBusResponseDTO = null;
		try {

			bookBusRequestDTO.setTotalPrice(
				bookBusRequestDTO.getTotalPrice().multiply(new BigDecimal(bookBusRequestDTO.getNoOfPassengers())));
			if (bookBusRequestDTO.getCardPaymentDetails() != null) {
				bookBusRequestDTO.getCardPaymentDetails().setTotalAmountPaid(bookBusRequestDTO.getTotalPrice());
			}
			bookBusResponseDTO = searchAndBookService.bookBus(bookBusRequestDTO);
			return bookBusResponseDTO;
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
		return bookBusResponseDTO;
	}

}
