PROAVOS.namespace("module.homepage");

PROAVOS.module.booking = function() {

	var page = 'Booking';

	var reserveSeat = function() {
		var data = {};
		data['busId'] = $("#txtBusId").val();
		data['noOfPassengers'] = $("#txtNoOfPassengers").val();
		data['totalPrice'] = $("#txtPrice").val();
		data['contactPerson'] = $("#txtContactName").val();
		data['contactPhone'] = $("#txtContactPhone").val();
		data['payNow'] = $("#sltPaymentOption").val() == 'PAYNOW';
		if (data['payNow']) {
			data['cardPaymentDetails'] = {};
			data.cardPaymentDetails['cardHolderName'] = $("#txtCardHolderName").val();
			data.cardPaymentDetails['cardNumber'] = $("#txtCardNumber").val();
			data.cardPaymentDetails['expiryMMYYYY'] = $("#txtExpDate").val();
			data.cardPaymentDetails['cvv'] = $("#txtCVV").val();
		}
		var ajaxData = {
			url : "book",
			contentType : 'application/json',
			data : JSON.stringify(data)
		};
		var successFn = function(res) {
			if (res.success) {
				generateSummary(res);
			} else {
				$("#errorMessage").empty().append(res.message).removeClass('hidden');
			}
		};
		PROAVOS.common.ajaxCall(ajaxData, successFn);
		$("#errorMessage").removeClass('hidden').addClass('hidden');
	};

	var generateSummary = function(data) {
		$('.book-form').removeClass('hidden').addClass('hidden');
		$('.book-summary').removeClass('hidden');
		$("#lblPNR").empty().append(data.bookingReference);
		$("#lblBookedDateTime").empty().append(moment(data.bookedDateTime).format("YYYY-MM-DD HH:mm"));
		$("#lblStatus").empty().append(data.bookingStatusDesc);
		$("#lblNoOfPax").empty().append(data.noOfPassengers);
		$("#lblTotalPrice").empty().append(data.totalPrice);
		$("#lblContactPerson").empty().append(data.contactPerson);
		$("#lblContactPhone").empty().append(data.contactPhone);
		$("#lblFrom").empty().append(data.busDetails.fromCity);
		$("#lblTo").empty().append(data.busDetails.toCity);
		$("#lblDepartureDate").empty().append(moment(data.busDetails.departureDateTime).format("YYYY-MM-DD HH:mm"));
		$("#lblArrivalDate").empty().append(moment(data.busDetails.arrivalDateTime).format("YYYY-MM-DD HH:mm"));
	};

	var changePaymentMethod = function() {
		var val = $(this).val();
		if (val == 'PAYLATER') {
			$('.paynow').hide();
		} else {
			$('.paynow').show();
		}
	};

	var formSubmit = function() {
		return false;
	};

	return {
		init : function() {
			$(document).on('click', "#btnBook", reserveSeat);
			$(document).on('change', "#sltPaymentOption", changePaymentMethod);
			$(document).on('submit', "#frmBooking", formSubmit);

			$("#sltPaymentOption").val('PAYLATER').trigger('change');
		}
	}
}();

$(function() {
	PROAVOS.module.booking.init();
});