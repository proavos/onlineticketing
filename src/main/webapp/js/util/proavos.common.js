// Create the namespace

var PROAVOS = PROAVOS || {};
PROAVOS.module = PROAVOS.module || {};


PROAVOS.namespace = function() {
	var a = arguments, o = null, i, j, d;
	for (i = 0; i < a.length; i = i + 1) {
		d = a[i].split(".");
		o = window.PROAVOS;
		for (j = 0; j < d.length; j = j + 1) {
			o[d[j]] = o[d[j]] || {};
			o = o[d[j]];
		}
	}
	return o;
};

PROAVOS.common = function() {
	return {
		ajaxCall : function(customOptions, doneFn, failFn) {
			var defaultOptions = {
				type : 'POST',
				async : true,
				cache : true,
				timeout : 120000,
				url : '',
				data : {},
				dataType : 'json'
			}, request;

			var options = $.extend({}, defaultOptions, customOptions);

			request = $.ajax(options);
			if (failFn) {
				request.fail(failFn);
			} else {
				request.fail(function(jqXHR, textStatus, errorThrown) {
					PROAVOS.message(PROAVOS.messageType.ERROR, "Your Session is expired. Please re-login to the system");
				});
			}
			if (doneFn) {
				request.done(doneFn);
			}
			return request;
		}
	};
}();

/*
 * Slide effect of the main search edit panels
 */
$.fn.extend({
	loadSelect : function(aList, isEmpty, sort) {
		return this.each(function() {
			var that = $(this);
			that.empty();
			var optionList = [];
			if (isEmpty) {
				var option = $("<option value=''>&nbsp;</option>");
				that.append(option);
			}
			$.each(aList, function(key, value) {
				optionList.push({
					val : key,
					text : value
				});
			});
			if (_.isUndefined(sort) || sort) {
				optionList.sort(function(a, b) {
					var textA = a.text, textB = b.text;
					if (textA < textB) //sort string ascending
						return -1;
					if (textA > textB)
						return 1;
					return 0; //default return value (no sorting)
				});
			}
			for (var i = 0; i < optionList.length; i++) {
				var option = $("<option value='" + optionList[i].val + "'>" + optionList[i].text + "</option>");
				that.append(option);
			}
		});
	},

	loadSelectFromList : function(list, keyForValue, keyForText, emptyOption, keyForSort) {
		return this.each(function() {
			var that = $(this);
			var option = null;
			that.empty();
			if (emptyOption) {
				option = $("<option value=''></option>");
				that.append(option);
			}
			if (!_.isUndefined([ keyForSort ])) {
				list.sort(function(a, b) {
					var textA = a[keyForSort], textB = b[keyForSort];
					if (textA < textB) //sort string ascending
						return -1;
					if (textA > textB)
						return 1;
					return 0; //default return value (no sorting)
				});
			}
			for (var i = 0; i < list.length; i++) {
				option = $("<option value='" + list[i][keyForValue] + "'>" + list[i][keyForText] + "</option>");
				that.append(option);
			}
		});
	}
});
