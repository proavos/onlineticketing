PROAVOS.namespace("module.homepage");

PROAVOS.module.homepage = function() {

	var page = 'Homepage';

	var loadInitialData = function() {
		var ajaxData = {
			url : "home/getAllCities"
		};
		var successFn = function(res) {
			$("#searchCityFrom").loadSelectFromList(res, 'cityId', 'cityName', true, true);
			$("#searchCityTo").loadSelectFromList(res, 'cityId', 'cityName', true, true);
		};
		PROAVOS.common.ajaxCall(ajaxData, successFn);

	};

	return {
		init : function() {
			loadInitialData();

			var checkout = $('#searchDate').datepicker().on('changeDate', function(ev) {
				checkout.hide();
			}).data('datepicker');

			$('#searchNoOfPax').TouchSpin();
		}
	}
}();

$(function() {
	PROAVOS.module.homepage.init();
});