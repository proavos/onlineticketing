PROAVOS.namespace("module.homepage");

PROAVOS.module.booking = function() {

	var page = 'Booking';

	var reserveSeat = function() {
		var data = {};
		data['busId'] = $("#txtBusId").val();
		data['noOfPassengers'] = $("#txtBusId").val();
		data['noOfPassengers'] = $("#txtNoOfPassengers").val();
		data['totalPrice'] = $("#txtPrice").val();
		data['contactPerson'] = $("#txtContactName").val();
		data['contactPhone'] = $("#txtContactPhone").val();
		data['payNow'] = $("#sltPaymentOption").val() == 'PAYNOW';
		data['cardPaymentDetails'] = {};
		data.cardPaymentDetails['cardHolderName'] = $("#txtCardHolderName").val();
		data.cardPaymentDetails['cardNumber'] = $("#txtCardNumber").val();
		data.cardPaymentDetails['expiryMMYYYY'] = $("#txtExpDate").val();
		data.cardPaymentDetails['cvv'] = $("#txtCVV").val();
		var ajaxData = {
			url : "book",
			contentType : 'application/json',
			data : JSON.stringify(data)
		};
		var successFn = function(res) {
			console.log(res);
		};
		PROAVOS.common.ajaxCall(ajaxData, successFn);

	};

	return {
		init : function() {
			$(document).on('click', "#btnBook", reserveSeat)

		}
	}
}();

$(function() {
	PROAVOS.module.booking.init();
});